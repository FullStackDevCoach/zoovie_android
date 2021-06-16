package com.example.zoovienew.customview.emojislider

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import com.example.zoovienew.customview.emojislider.drawables.CircleDrawable
import com.example.zoovienew.customview.emojislider.drawables.ResultDrawable
import com.example.zoovienew.customview.emojislider.drawables.TrackDrawable
import com.cpiz.android.bubbleview.BubbleStyle
import com.cpiz.android.bubbleview.BubbleTextView
import com.example.zoovienew.R
import com.facebook.rebound.*
import kotlin.math.roundToInt

class EmojiSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private companion object {
        const val INITIAL_POSITION = 0.25f
        const val INITIAL_AVERAGE_POSITION = 0.5f
        const val INITIAL_THUMB_SIZE_PERCENT_WHEN_PRESSED = 0.9

        const val INITIAL_AUTO_DISMISS_TIMER = 2500

        const val TENSION_SMALL = 3.0
        const val TENSION_BIG = 40.0

        const val FRICTION_SMALL = 5.0
        const val FRICTION_BIG = 7.0
    }

    private val desiredWidth: Int
    private val desiredHeight: Int

    // these will be used on onTouch
    private var mScaledTouchSlop = 0
    private var mIsDragging = false
    private val mThumbOffset: Int
    private var mTouchDownX = 0f

    var registerTouchOnTrack = true


    var isUserSeekable = true


    var isValueSelected = false


    var thumbSizePercentWhenPressed = INITIAL_THUMB_SIZE_PERCENT_WHEN_PRESSED

    var allowReselection = false


    var averageProgressValue: Float = INITIAL_AVERAGE_POSITION


    var shouldDisplayResultPicture: Boolean = true


    var shouldDisplayAverage: Boolean = true
        set(value) {
            field = value
            invalidate()
        }


    var shouldDisplayTooltip: Boolean = true

    var tooltipText: String = ""

    var tooltipAutoDismissTimer = INITIAL_AUTO_DISMISS_TIMER

    private var floatingEmoji = FloatingEmoji(context)


    var floatingEmojiDirection: FloatingEmoji.Direction = FloatingEmoji.Direction.UP

    var emoji = "🙂"
        set(value) {
            field = value
            updateThumb(field)
        }

    var sliderParticleSystem: View? = null
        set(value) {
            field = value

            if (value?.background !is FloatingEmoji) {
                value?.background = floatingEmoji
            } else {
                floatingEmoji = value.background as FloatingEmoji
            }
        }


    var progress: Float = INITIAL_POSITION
        set(value) {
            field = value.limitToRange()

            trackDrawable.percentProgress = field
            trackDrawable.invalidateSelf()
            invalidate()
        }

    var colorTrack: Int
        get() = trackDrawable.trackColor.color
        set(value) {
            trackDrawable.trackColor.color = value
        }

    var colorStart: Int
        get() = trackDrawable.colorStart
        set(value) {
            trackDrawable.colorStart = value
        }

    var colorEnd: Int
        get() = trackDrawable.colorEnd
        set(value) {
            trackDrawable.colorEnd = value
        }

    lateinit var thumbDrawable: Drawable

    val trackDrawable: TrackDrawable = TrackDrawable()

    val averageDrawable: CircleDrawable = CircleDrawable(context)

    val resultDrawable: ResultDrawable = ResultDrawable(context)

    var positionListener: ((Float) -> Unit)? = null

    var startTrackingListener: (() -> Unit)? = null

    var stopTrackingListener: (() -> Unit)? = null

    private val mSpringSystem = SpringSystem.create()
    private val mSpringListener = object : SimpleSpringListener() {
        override fun onSpringUpdate(spring: Spring?) {
            invalidate()
        }
    }

    private val mThumbSpring = mSpringSystem.createSpring()
        .origamiConfig(TENSION_SMALL, FRICTION_SMALL)
        .setCurrentValue(1.0)
        .setEndValue(1.0)
        .setOvershootClampingEnabled(true)

    private val mAverageSpring: Spring = mSpringSystem.createSpring()
        .origamiConfig(TENSION_BIG, FRICTION_BIG)
        .setCurrentValue(0.0)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = resolveSizeAndState(desiredWidth, widthMeasureSpec, 0)
        val h = resolveSizeAndState(desiredHeight, heightMeasureSpec, 0)
        setMeasuredDimension(w, h)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        this.trackDrawable.setBounds(
            0 + Math.max(paddingLeft, mThumbOffset),
            h / 2 - trackDrawable.intrinsicHeight / 2,
            w - Math.max(paddingRight, mThumbOffset),
            h / 2 + trackDrawable.intrinsicHeight / 2
        )
    }

    fun valueSelectedAnimated() {
        if (allowReselection) return

        resultDrawable.endValue = 1.0
        mAverageSpring.endValue = 1.0

        if (shouldDisplayAverage && shouldDisplayTooltip) {
            showAverageTooltip()
        }

        mThumbSpring.endValue = 0.0
        isUserSeekable = false
        isValueSelected = true

        invalidate()
    }


    fun valueSelectedNow() {
        if (allowReselection) return

        resultDrawable.currentValue = 1.0
        mAverageSpring.currentValue = 1.0

        mThumbSpring.currentValue = 0.0
        isUserSeekable = false
        isValueSelected = true

        invalidate()
    }

    fun resetAnimated() {
        resultDrawable.endValue = 0.0
        mAverageSpring.endValue = 0.0

        mThumbSpring.endValue = 1.0
        isUserSeekable = true
        isValueSelected = false

        invalidate()
    }


    fun resetNow() {
        resultDrawable.currentValue = 0.0
        mAverageSpring.currentValue = 0.0

        mThumbSpring.currentValue = 1.0
        isUserSeekable = true
        isValueSelected = false

        invalidate()
    }


    fun showAverageTooltip() {

        val finalPosition = SpringUtil.mapValueFromRangeToRange(
            (averageProgressValue * trackDrawable.bounds.width()).toDouble(),
            0.0,
            trackDrawable.bounds.width().toDouble(),
            -(trackDrawable.bounds.width() / 2).toDouble(),
            (trackDrawable.bounds.width() / 2).toDouble()
        ).toInt()

        val rootView = View.inflate(context, R.layout.bubble, null) as BubbleTextView
        if (tooltipText.isNotBlank()) {
            rootView.text = tooltipText
        }

        val window = BernardoPopupWindow(rootView, rootView)
        window.xPadding = finalPosition
        window.yPadding = trackDrawable.bounds.top
        window.setCancelOnTouch(true)
        window.setCancelOnTouchOutside(true)
        window.setCancelOnLater(tooltipAutoDismissTimer.toLong())
        window.showArrowTo(this, BubbleStyle.ArrowDirection.Up)
    }


    fun startAnimation() {
        mThumbSpring.addListener(mSpringListener)
        mAverageSpring.addListener(mSpringListener)
    }


    fun stopAnimation() {
        mThumbSpring.removeListener(mSpringListener)
        mAverageSpring.removeListener(mSpringListener)
    }

    override fun scheduleDrawable(drawable: Drawable, runnable: Runnable, j: Long) = Unit
    override fun unscheduleDrawable(drawable: Drawable, runnable: Runnable) = Unit
    override fun invalidateDrawable(drawable: Drawable) = invalidate()

    init {

        val density = context.resources.displayMetrics.density

        desiredWidth = (56 * density * 4).toInt()
        desiredHeight =
                (density * 8 + context.resources.getDimension(R.dimen.slider_sticker_slider_handle_size)).roundToInt()
        mThumbOffset = desiredHeight / 2

        startAnimation()

        this.resultDrawable.callback = this
        this.averageDrawable.callback = this
        this.trackDrawable.callback = this

        setResultHandleSize(context.resources.getDimensionPixelSize(R.dimen.slider_sticker_slider_handle_size))
        trackDrawable.totalHeight =
                context.resources.getDimensionPixelSize(R.dimen.slider_sticker_slider_height)
        trackDrawable.setTrackHeight(context.resources.getDimension(R.dimen.slider_sticker_slider_track_height))
        trackDrawable.invalidateSelf()

        if (attrs != null) {
            val array = context.obtainStyledAttributes(attrs, R.styleable.EmojiSlider)

            try {
                progress = array.getProgress()

                colorStart = array.getProgressGradientStart()
                colorEnd = array.getProgressGradientEnd()
                colorTrack = array.getSliderTrackColor()

                colorStart = array.getProgressGradientStart()
                colorEnd = array.getProgressGradientEnd()

                registerTouchOnTrack = array.getThumbAllowScrollAnywhere()
                allowReselection = array.getAllowReselection()
                isUserSeekable = array.getIsTouchDisabled()
                averageProgressValue = array.getAverageProgress()
                shouldDisplayTooltip = array.getShouldDisplayPopup()
                shouldDisplayAverage = array.getShouldDisplayAverage()
                shouldDisplayResultPicture = array.getShouldDisplayResultPicture()
                tooltipAutoDismissTimer = array.getTooltipDismissTimer()
                thumbSizePercentWhenPressed = array.getThumbSizeWhenPressed()

                floatingEmojiDirection = if (array.getEmojiGravity() == 0) {
                    FloatingEmoji.Direction.UP
                } else {
                    FloatingEmoji.Direction.DOWN
                }

                array.getTooltipText()?.let {
                    tooltipText = it
                }

                emoji = array.getEmoji()

                invalidateAll()

            } finally {
                array.recycle()
            }
        } else {
            colorStart = context.getColorCompat(R.color.slider_gradient_start)
            colorEnd = context.getColorCompat(R.color.slider_gradient_end)
            colorTrack = context.getColorCompat(R.color.slider_track)
            emoji = emoji
        }

        mScaledTouchSlop = ViewConfiguration.get(context).scaledTouchSlop
    }


    fun invalidateAll() {
        if (shouldDisplayAverage) averageDrawable.invalidateSelf()
        if (shouldDisplayResultPicture) resultDrawable.invalidateSelf()

        trackDrawable.invalidateSelf()
        thumbDrawable.invalidateSelf()
        invalidate()
    }


    fun setResultHandleSize(size: Int) {
        resultDrawable.sizeHandle = size.toFloat()
        resultDrawable.imageDrawable.invalidateSelf()
        resultDrawable.circleDrawable.invalidateSelf()
    }

    private fun TypedArray.getProgressGradientStart(): Int {
        return this.getColor(
            R.styleable.EmojiSlider_bar_progress_color_start,
            context.getColorCompat(R.color.slider_gradient_start)
        )
    }

    private fun TypedArray.getProgressGradientEnd(): Int {
        return this.getColor(
            R.styleable.EmojiSlider_bar_progress_color_end,
            context.getColorCompat(R.color.slider_gradient_end)
        )
    }

    private fun TypedArray.getSliderTrackColor(): Int {
        return this.getColor(
            R.styleable.EmojiSlider_bar_track_color,
            context.getColorCompat(R.color.slider_track)
        )
    }

    private fun TypedArray.getProgress(): Float =
        this.getFloat(R.styleable.EmojiSlider_progress_value, progress).limitToRange()

    private fun TypedArray.getEmoji(): String =
        this.getString(R.styleable.EmojiSlider_emoji) ?: emoji

    private fun TypedArray.getEmojiGravity(): Int =
        this.getInt(R.styleable.EmojiSlider_particle_direction, 0)

    private fun TypedArray.getThumbAllowScrollAnywhere(): Boolean =
        this.getBoolean(
            R.styleable.EmojiSlider_register_touches_outside_thumb, registerTouchOnTrack
        )

    private fun TypedArray.getAllowReselection(): Boolean =
        this.getBoolean(R.styleable.EmojiSlider_allow_reselection, allowReselection)

    private fun TypedArray.getAverageProgress(): Float =
        this.getFloat(R.styleable.EmojiSlider_average_progress, averageProgressValue).limitToRange()

    private fun TypedArray.getIsTouchDisabled(): Boolean =
        this.getBoolean(R.styleable.EmojiSlider_is_touch_disabled, isUserSeekable)

    private fun TypedArray.getShouldDisplayPopup(): Boolean =
        this.getBoolean(R.styleable.EmojiSlider_should_display_tooltip, shouldDisplayTooltip)

    private fun TypedArray.getShouldDisplayAverage(): Boolean =
        this.getBoolean(R.styleable.EmojiSlider_should_display_average, shouldDisplayAverage)

    private fun TypedArray.getShouldDisplayResultPicture(): Boolean =
        this.getBoolean(
            R.styleable.EmojiSlider_should_display_result_picture,
            shouldDisplayResultPicture
        )

    private fun TypedArray.getTooltipText(): String? =
        this.getString(R.styleable.EmojiSlider_tooltip_text)

    private fun TypedArray.getTooltipDismissTimer(): Int =
        this.getInt(R.styleable.EmojiSlider_tooltip_dismiss_timer, tooltipAutoDismissTimer)

    private fun TypedArray.getThumbSizeWhenPressed(): Double =
        this.getFloat(
            R.styleable.EmojiSlider_thumb_size_percent_on_pressed,
            thumbSizePercentWhenPressed.toFloat()
        ).limitToRange().toDouble()


    private fun progressChanged(progress: Float) {
        if (sliderParticleSystem == null) return

        val (paddingLeft, paddingTop) = getPaddingForFloatingEmoji()

        floatingEmoji.onProgressChanged(
            percent = progress,
            paddingLeft = paddingLeft,
            paddingTop = paddingTop
        )
    }

    private fun progressStarted() {
        if (sliderParticleSystem == null) return

        val (paddingLeft, paddingTop) = getPaddingForFloatingEmoji()

        floatingEmoji.progressStarted(
            emoji = emoji,
            direction = floatingEmojiDirection,
            paddingLeft = paddingLeft,
            paddingTop = paddingTop
        )
    }

    private fun getPaddingForFloatingEmoji(): Pair<Float, Float> {
        val sliderLocation = IntArray(2)
        getLocationOnScreen(sliderLocation)

        val particleLocation = IntArray(2)
        sliderParticleSystem!!.getLocationOnScreen(particleLocation)

        val widthPosition = progress * trackDrawable.bounds.width()

        return Pair(
            sliderLocation[0].toFloat()
                    + trackDrawable.bounds.left
                    + widthPosition
                    - particleLocation[0],
            sliderLocation[1].toFloat()
                    + trackDrawable.bounds.top
                    + dpToPx(context, 32f)
                    - particleLocation[1]
        )
    }

    private fun updateThumb(emoji: String) {
        thumbDrawable = textToDrawable(
            context = this.context,
            text = emoji,
            size = R.dimen.slider_sticker_slider_handle_size
        )
        thumbDrawable.callback = this
        invalidate()
    }


    fun setResultDrawable(bitmap: Bitmap) {
        resultDrawable.setDrawableFromBitmap(bitmap)
    }

    private fun Float.limitToRange() = Math.max(Math.min(this, 1f), 0f)

    private fun Rect.containsXY(motionEvent: MotionEvent): Boolean =
        this.contains(motionEvent.x.toInt(), motionEvent.y.toInt())

    private fun Spring.origamiConfig(tension: Double, friction: Double): Spring =
        this.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(tension, friction))

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        trackDrawable.draw(canvas)
        if (shouldDisplayAverage) drawAverage(canvas)
        drawThumb(canvas)
        if (shouldDisplayResultPicture) drawProfilePicture(canvas)
    }

    private fun drawThumb(canvas: Canvas) {

        val widthPosition = progress * trackDrawable.bounds.width()
        val thumbScale = mThumbSpring.currentValue.toFloat()

        canvas.save()
        canvas.translate(trackDrawable.bounds.left.toFloat(), trackDrawable.bounds.top.toFloat())
        canvas.scale(
            thumbScale,
            thumbScale,
            widthPosition,
            (trackDrawable.bounds.bottom - trackDrawable.bounds.top) / 2f
        )

        thumbDrawable.updateDrawableBounds(widthPosition.roundToInt())
        thumbDrawable.draw(canvas)

        canvas.restore()
    }

    private fun drawProfilePicture(canvas: Canvas) {

        val widthPosition = progress * trackDrawable.bounds.width()
        val height: Float = trackDrawable.bounds.height() / 2f

        canvas.save()
        canvas.translate(trackDrawable.bounds.left.toFloat(), trackDrawable.bounds.top.toFloat())
        canvas.scale(1f, 1f, widthPosition, height)

        resultDrawable.updateDrawableBounds(widthPosition.roundToInt())
        resultDrawable.draw(canvas)

        canvas.restore()
    }

    private fun drawAverage(canvas: Canvas) {
        averageDrawable.outerColor = getCorrectColor(
            colorStart,
            colorEnd,
            averageProgressValue
        )

        averageDrawable.invalidateSelf()

        val scale = mAverageSpring.currentValue.toFloat()

        val widthPosition = averageProgressValue * trackDrawable.bounds.width()
        val heightPosition = (trackDrawable.bounds.height() / 2).toFloat()

        canvas.save()
        canvas.translate(trackDrawable.bounds.left.toFloat(), trackDrawable.bounds.top.toFloat())
        canvas.scale(scale, scale, widthPosition, heightPosition)

        averageDrawable.updateDrawableBounds(widthPosition.roundToInt())
        averageDrawable.draw(canvas)

        canvas.restore()
    }

    private fun Drawable.updateDrawableBounds(widthPosition: Int) {

        val customIntrinsicWidth = this.intrinsicWidth / 2
        val customIntrinsicHeight = this.intrinsicHeight / 2
        val heightPosition = trackDrawable.bounds.height() / 2

        this.setBounds(
            widthPosition - customIntrinsicWidth,
            heightPosition - customIntrinsicHeight,
            widthPosition + customIntrinsicWidth,
            heightPosition + customIntrinsicHeight
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        if (!isUserSeekable || !isEnabled) {
            return false
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> onTouchDown(event)
            MotionEvent.ACTION_MOVE -> onActionMove(event)
            MotionEvent.ACTION_UP -> {
                if (mIsDragging) performClick()
                onActionUp(event)
            }
            MotionEvent.ACTION_CANCEL -> {
                if (mIsDragging) {
                    mIsDragging = false
                    isPressed = false
                }
                invalidate() // see above explanation
            }
        }

        return true
    }

    private fun onTouchDown(event: MotionEvent) {
        if (isScrollContainer) {
            mTouchDownX = event.x
        } else {
            startDrag(event)
        }
    }

    private fun onActionMove(event: MotionEvent) {
        if (mIsDragging) {
            trackTouchEvent(event)
        } else {
            if (Math.abs(event.x - mTouchDownX) > mScaledTouchSlop) {
                startDrag(event)
            }
        }
    }

    private fun onActionUp(event: MotionEvent) {
        if (!mIsDragging && registerTouchOnTrack && trackDrawable.bounds.containsXY(event)) {

            mIsDragging = true
            progressStarted()
            trackTouchEvent(event)
        }

        onCancelTouch()
        mIsDragging = false
        isPressed = false
        invalidate()
    }

    private fun trackTouchEvent(event: MotionEvent) {
        if (mIsDragging) {
            val x = event.x.toInt() - trackDrawable.bounds.left
            progress = x / trackDrawable.bounds.width().toFloat()

            progressChanged(progress)
            positionListener?.invoke(progress)
        }
    }

    private fun onCancelTouch() {
        mThumbSpring.endValue = 1.0

        if (mIsDragging) {
            valueSelectedAnimated()
            floatingEmoji.onStopTrackingTouch()
            stopTrackingListener?.invoke()
        }
    }


    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    private fun startDrag(event: MotionEvent) {

        val x = event.x.toInt() - trackDrawable.bounds.left
        val y = event.y.toInt() - trackDrawable.bounds.top

        if (!thumbDrawable.bounds.contains(x, y) &&
            !(registerTouchOnTrack && trackDrawable.bounds.containsXY(event))
        ) return

        setViewPressed(true)
        progressStarted()
        mThumbSpring.endValue = thumbSizePercentWhenPressed
        startTrackingListener?.invoke()
        mIsDragging = true
        attemptClaimDrag()
    }

    private fun setViewPressed(pressed: Boolean) {
        dispatchSetPressed(pressed)
    }

    private fun attemptClaimDrag() {
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true)
        }
    }
}


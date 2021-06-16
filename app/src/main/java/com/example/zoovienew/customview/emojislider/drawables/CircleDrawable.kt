package com.example.zoovienew.customview.emojislider.drawables

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import com.example.zoovienew.R
import com.example.zoovienew.customview.emojislider.getColorCompat

class CircleDrawable(context: Context) : Drawable() {
    var ringThickness =
        context.resources.getDimension(R.dimen.slider_handle_ring_thickness)
    private val averagePaint = Paint(1)
    internal var radius: Float =
        context.resources.getDimension(R.dimen.slider_sticker_slider_vote_average_handle_size) / 2

    var innerColor = Color.WHITE
    var outerColor = context.getColorCompat(R.color.purple_200)

    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    override fun draw(canvas: Canvas) {

        val exactCenterX = bounds.exactCenterX()
        val exactCenterY = bounds.exactCenterY()

        this.averagePaint.color = this.outerColor
        canvas.drawCircle(exactCenterX, exactCenterY, this.radius, this.averagePaint)
        this.averagePaint.color = this.innerColor
        canvas.drawCircle(
            exactCenterX,
            exactCenterY,
            this.radius - this.ringThickness,
            this.averagePaint
        )
    }

    override fun getIntrinsicHeight(): Int = (radius * 2).toInt()

    override fun getIntrinsicWidth(): Int = (radius * 2).toInt()

    override fun setAlpha(alpha: Int) {
        this.averagePaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        this.averagePaint.colorFilter = colorFilter
    }
}

/*
 * Copyright (C) 2017 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.zoovienew.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.example.zoovienew.R;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnDismissedListener;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

public class PowerMenuUtils {

    public static PowerMenu getHamburgerPowerMenu(
            Context context,
            LifecycleOwner lifecycleOwner,
            OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener,
            OnDismissedListener onDismissedListener) {

        return new PowerMenu.Builder(context)
                .addItem(new PowerMenuItem("Monday", false))
                .addItem(new PowerMenuItem("Tuesday", false))
                .addItem(new PowerMenuItem("Wednesday", false))
                .addItem(new PowerMenuItem("Thursday", false))
                .addItem(new PowerMenuItem("Friday", false))
                .addItem(new PowerMenuItem("Saturday", false))
                .addItem(new PowerMenuItem("Sunday", false))
                .setDividerHeight(3)
                .setPadding(5)
                .setLifecycleOwner(lifecycleOwner)
                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setTextColor(ContextCompat.getColor(context, R.color.white))
                .setTextSize(14)
                .setTextGravity(Gravity.CENTER)
                .setSelectedTextColor(Color.WHITE)
                .setMenuColor(ContextCompat.getColor(context, R.color.grey))
                .setSelectedMenuColor(ContextCompat.getColor(context, R.color.btn_color_red))
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .setOnDismissListener(onDismissedListener)
                .setPreferenceName("HamburgerPowerMenu")
                .setInitializeRule(Lifecycle.Event.ON_CREATE, 0)
                .setShowBackground(false)
                .setFocusable(true)
                .build();

    }

    public static PowerMenu getVenueTimePowerMenu(
            Context context,
            LifecycleOwner lifecycleOwner,
            OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener,
            OnDismissedListener onDismissedListener) {

        return new PowerMenu.Builder(context)
                .addItem(new PowerMenuItem("6 AM LOUNGE", false))
                .addItem(new PowerMenuItem("8 AM ATLANTA", false))
                .addItem(new PowerMenuItem("9 AM LOUNGE", false))
                .addItem(new PowerMenuItem("10 AM ATLANTA", false))
                .addItem(new PowerMenuItem("11 AM LOUNGE", false))
                .addItem(new PowerMenuItem("4 PM ATLANTA", false))
                .addItem(new PowerMenuItem("6 PM LOUNGE", false))
                .setDividerHeight(2)
                .setAutoDismiss(true)
                .setLifecycleOwner(lifecycleOwner)
                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setTextColor(ContextCompat.getColor(context, R.color.black))
                .setTextSize(14)
                .setTextGravity(Gravity.CENTER)
                .setSelectedTextColor(Color.WHITE)
                .setMenuColor(ContextCompat.getColor(context, R.color.white))
                .setSelectedMenuColor(ContextCompat.getColor(context, R.color.btn_color_red))
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .setOnDismissListener(onDismissedListener)
                .setPreferenceName("HoursPowerMenu")
                .setInitializeRule(Lifecycle.Event.ON_CREATE, 0)
                .setShowBackground(false)
                .setFocusable(true)
                .build();

    }
}

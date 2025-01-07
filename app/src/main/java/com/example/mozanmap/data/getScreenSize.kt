package com.example.mozanmap.data

import android.app.Activity
import android.os.Build

fun getScreenSize(activity: Activity): Pair<Int, Int> =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics = activity.windowManager.currentWindowMetrics
        val bounds = windowMetrics.bounds
        Pair(bounds.width(), bounds.height())
    } else {
        val displayMetrics = activity.resources.displayMetrics
        Pair(displayMetrics.widthPixels, displayMetrics.heightPixels)
    }

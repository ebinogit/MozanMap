package com.example.mozanmap

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

fun getAdjustedSize(context: Context, baseDp: Float, referenceAspectRatio: Float): Float {
    val metrics: DisplayMetrics = context.resources.displayMetrics
    val screenWidth = metrics.widthPixels / metrics.density
    val screenHeight = metrics.heightPixels / metrics.density
    val screenAspectRatio = screenWidth / screenHeight

    // 画面のアスペクト比に基づいて dp を調整
    return if (screenAspectRatio > referenceAspectRatio) {
        baseDp * (referenceAspectRatio / screenAspectRatio)
    } else {
        baseDp * (screenAspectRatio / referenceAspectRatio)
    }
}
fun Float.toPx(context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        context.resources.displayMetrics
    )
}

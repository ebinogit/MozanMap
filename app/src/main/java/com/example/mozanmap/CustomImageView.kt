package com.example.mozanmap

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Matrix
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.pow
import kotlin.math.sqrt

class CustomImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var matrix: Matrix = Matrix()
    private val scaleMax = 3.0f
    private val scaleMin = 0.1f
    private var previousX = 0f
    private var previousY = 0f
    private var previousDistance = 0f // 2本指間の距離を記録
    private var isPinchMode = false // ピンチ操作中かどうかを記録

    init {
        scaleType = ScaleType.MATRIX
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.pointerCount) {
            1 -> handleSingleTouch(event) // スライド（1本指操作）
            2 -> handlePinchGesture(event) // ピンチイン・ピンチアウト（2本指操作）
        }

        // 指がすべて離された場合
        if (event.actionMasked == MotionEvent.ACTION_UP || event.actionMasked == MotionEvent.ACTION_POINTER_UP) {
            if (event.pointerCount == 1) {
                // 最後の指が離された場合にピンチモードを解除
                isPinchMode = false
                performClick()
            }
        }

        return true
    }

    private fun handleSingleTouch(event: MotionEvent) {
        if (isPinchMode) return // ピンチ操作中はスライドを無効化
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                previousX = event.x
                previousY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = event.x - previousX
                val dy = event.y - previousY
                previousX = event.x
                previousY = event.y
                Log.d(TAG,"")
                // 平行移動を適用
                matrix.postTranslate(dx, dy)
                imageMatrix = matrix
                invalidate()
            }
        }
    }

    private fun handlePinchGesture(event: MotionEvent) {
        if (event.pointerCount < 2) return // 2本指がない場合は無視

        val x1 = event.getX(0)
        val y1 = event.getY(0)
        val x2 = event.getX(1)
        val y2 = event.getY(1)

        val distance = sqrt((x2 - x1).toDouble().pow(2.0) + (y2 - y1).toDouble().pow(2.0)).toFloat()

        when (event.actionMasked) {
            MotionEvent.ACTION_POINTER_DOWN -> {
                isPinchMode = true // ピンチモードを有効化
                previousDistance = distance
            }
            MotionEvent.ACTION_MOVE -> {
                if (previousDistance > 0) {
                    val scaleFactor = distance / previousDistance
                    val focusX = (x1 + x2) / 2
                    val focusY = (y1 + y2) / 2

                    // 現在のスケール値を取得
                    val currentScale = getScaleXFromMatrix()
                    val newScale = currentScale * scaleFactor

                    // スケール範囲を制限
                    if (newScale in scaleMin..scaleMax) {
                        matrix.postScale(scaleFactor, scaleFactor, focusX, focusY)
                        imageMatrix = matrix
                        invalidate()
                    }
                    previousDistance = distance
                }
            }
        }
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    // Matrixから指定された要素の値を取得する補助関数
    private fun getScaleXFromMatrix(): Float {
        val values = FloatArray(9)
        matrix.getValues(values)
        return values[Matrix.MSCALE_X]
    }
}

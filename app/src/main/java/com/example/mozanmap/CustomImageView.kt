package com.example.mozanmap
import android.app.Activity
import android.util.Log
import android.content.Context
import android.graphics.Matrix
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.pow
import kotlin.math.sqrt
import com.example.mozanmap.data.PimData

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
    private val buttons = arrayOfNulls<ImageButton>(34)

    //ボタンをセット
    fun setButton(id: Int, button: ImageButton) {
        buttons[id] = button
        val pos = PimData.pinItem[id]
        updateButtonPosition(button, pos.posX, pos.posY)
    }

    //画像をセット
    init {
        scaleType = ScaleType.MATRIX
        updateMapScale(0.1f, 0f, 0f)
        updateMapPos(100f, 500f)
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
    private fun updateButtonPosition(btn:ImageButton,posX: Float, posY: Float) {
        val scale = resources.displayMetrics.density
        val currentScale = getScaleXFromMatrix()
//        val x = 1380 - (1380 / (currentScale * 10)) + posX*scale
//        val y = 1400 - (1400 / (currentScale * 10)) + posY*scale
        val x = 400*scale - (400*scale / (currentScale * 10)) + posX*scale
        val y = 410*scale - (410*scale / (currentScale * 10)) + posY*scale
        val points = floatArrayOf(x, y)
        matrix.mapPoints(points)
        // ボタンの位置を設定
        btn.x = points[0]
        btn.y = points[1]
        btn.scaleX = currentScale
        btn.scaleY = currentScale
    }
    private fun updateMapPos(posX:Float,posY: Float){
        matrix.postTranslate(posX, posY)
        imageMatrix = matrix
        invalidate()
    }
    private fun updateMapScale(scale:Float,focusX:Float,focusY:Float){
        matrix.postScale(scale, scale, focusX, focusY)
        imageMatrix = matrix
        invalidate()
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
                updateMapPos(dx,dy)
                buttons.forEachIndexed { index, button ->
                    button?.let {
                        val position = PimData.pinItem[index]
                        updateButtonPosition(it, position.posX, position.posY)
                    }
                }
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
                        updateMapScale(scaleFactor,focusX,focusY)
                        buttons.forEachIndexed { index, button ->
                            button?.let {
                                val position = PimData.pinItem[index]
                                updateButtonPosition(it, position.posX, position.posY)
                            }
                        }
                    }
                    previousDistance = distance
                }
            }
        }
    }
    override fun performClick(): Boolean {
        super.performClick()
        updateMapPos(0f,0f)
        return true
    }
    // Matrixから指定された要素の値を取得
    private fun getScaleXFromMatrix(): Float {
        val values = FloatArray(9)
        matrix.getValues(values)
        return values[Matrix.MSCALE_X]
    }
}
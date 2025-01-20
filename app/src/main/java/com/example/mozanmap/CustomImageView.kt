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

    data class ButtonPosition(val x: Float, val y: Float)

    private val buttonPositions = listOf(
        ButtonPosition(-50f, -137f),
        ButtonPosition(-327f, 47f),
        ButtonPosition(33f, 83f),
        ButtonPosition(390f, -250f),
        ButtonPosition(67f, 150f),
        ButtonPosition(350f, 160f),
        ButtonPosition(183f, 517f),
        ButtonPosition(863f, -117f),
        ButtonPosition(433f, -7f),
        ButtonPosition(1950f, 420f),
        ButtonPosition(823f, 83f),
        ButtonPosition(800f, 273f),
        ButtonPosition(1635f, 273f),
        ButtonPosition(1515f, 83f),
        ButtonPosition(1085f, -30f),
        ButtonPosition(1320f, -30f),
        ButtonPosition(1075f, 185f),
        ButtonPosition(1330f, 185f),
        ButtonPosition(833f, -243f),
        ButtonPosition(1160f, -195f),
        ButtonPosition(2030f, -210f),
        ButtonPosition(2285f, -325f),
        ButtonPosition(1990f, 185f),
        ButtonPosition(2285f, 380f),
        ButtonPosition(1920f, 1440f),
        ButtonPosition(930f, 520f),
        ButtonPosition(1490f, 530f),
        ButtonPosition(1820f, 730f),
        ButtonPosition(920f, 730f),
        ButtonPosition(1395f, 1295f),
        ButtonPosition(1540f, 1700f),
        ButtonPosition(1705f, 1810f),
        ButtonPosition(740f, 1140f),
        ButtonPosition(1790f, 1035f),
    )

    //ボタンをセット
    fun setButton(id: Int, button: ImageButton) {
        buttons[id] = button
        val pos = buttonPositions[id]
        updateButtonPosition(button, pos.x, pos.y)
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
        Log.d("scale","$scale")
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
    //    private fun updateButtonPosition(btn:ImageButton,posX: Float, posY: Float) {
//        val currentScale = getScaleXFromMatrix()
//        val x = 1200 - (1200 / (currentScale * 10)) + posX
//        val y = 1249 - (1249 / (currentScale * 10)) + posY
//        val points = floatArrayOf(x, y)
//        matrix.mapPoints(points)
//        // ボタンの位置を設定
//        btn.x = points[0]
//        btn.y = points[1]
//        btn.scaleX = currentScale
//        btn.scaleY = currentScale
//    }
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
                        val position = buttonPositions[index]
                        updateButtonPosition(it, position.x, position.y)
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
                                val position = buttonPositions[index]
                                updateButtonPosition(it, position.x, position.y)
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
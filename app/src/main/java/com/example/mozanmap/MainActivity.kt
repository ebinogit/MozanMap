package com.example.mozanmap

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import com.example.mozanmap.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f
    private var focusX = 0f
    private var focusY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dX = 0f
        var dY = 0f

        // ScaleGestureDetectorの初期化
        scaleGestureDetector = ScaleGestureDetector(this, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
                focusX = detector.focusX
                focusY = detector.focusY
                return true
            }

            override fun onScale(detector: ScaleGestureDetector): Boolean {
                val previousScaleFactor = scaleFactor
                scaleFactor *= detector.scaleFactor
                scaleFactor = scaleFactor.coerceIn(0.1f, 10.0f)

                val focusXDelta = focusX - (binding.imageView.width / 2)
                val focusYDelta = focusY - (binding.imageView.height / 2)

                binding.imageView.pivotX = focusXDelta / previousScaleFactor
                binding.imageView.pivotY = focusYDelta / previousScaleFactor

                binding.imageView.scaleX = scaleFactor
                binding.imageView.scaleY = scaleFactor

                return true
            }

            override fun onScaleEnd(detector: ScaleGestureDetector) {
                super.onScaleEnd(detector)
                // ここで追加の位置調整を行うことができます
            }
        })

        binding.imageView.setOnTouchListener { view, event ->
            scaleGestureDetector.onTouchEvent(event)
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dX = view.x - event.rawX
                    dY = view.y - event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    if (!scaleGestureDetector.isInProgress) {
                        view.animate()
                            .x(event.rawX + dX)
                            .y(event.rawY + dY)
                            .setDuration(0)
                            .start()
                    }
                }
                else -> false
            }
            true
        }
    }
}

package com.usu.animation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class AnimationView(context: Context): View(context) {
    private val paint = Paint()
    private var radius = 100f
    private var redValue = 0
    private var yPos = 0f

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            addUpdateListener {
                val animatedValue = it.animatedValue as Float
                radius = ((animatedValue) * ((width / 2f)))
                redValue = (animatedValue * 255).toInt()
                yPos = ((animatedValue * height) - radius)
                repeatMode = ValueAnimator.REVERSE
                repeatCount = ValueAnimator.INFINITE
                invalidate()
            }
            start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate(width / 2f, yPos)
        paint.setColor(Color.rgb(redValue, 100, 100))
        canvas.drawCircle(0f, 0f, radius, paint)
    }
}
package com.usu.bouncingball

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.pow

class Ball(val height: Float, val xPos: Float, var yPos: Float) {
    private var velocity = 0f
    private val radius = 50f
    public fun update(delta: Long) {
        velocity = (velocity + (9.8f * 5) * (delta.toDouble() / 1000.0)).toFloat()
        yPos += velocity
        if (yPos + radius > height) {
            yPos = height - radius
            velocity *= -1.1f
        }
        if (yPos - radius < 0) {
            yPos = 0f + radius
            velocity *= -1.1f
        }
    }

    public fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawCircle(xPos, yPos, radius, paint)
    }
}
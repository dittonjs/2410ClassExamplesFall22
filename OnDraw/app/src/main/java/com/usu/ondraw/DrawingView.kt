package com.usu.ondraw

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout


data class Circle(val cX: Float, val cY: Float, val radius: Float)

@SuppressLint("ClickableViewAccessibility")
class DrawingView(context: Context): View(context) {
    private val paint = Paint()
    private val circles = mutableListOf<Circle>()
    init {
        setOnTouchListener { _, motionEvent ->
            println("I got called")
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                println(motionEvent.pointerCount)
                for (fingerIndex in 0 until motionEvent.pointerCount) {
                    circles.add(Circle(motionEvent.getX(fingerIndex), motionEvent.getY(fingerIndex), 25f))
                }
                invalidate()
            }
            return@setOnTouchListener false
        }
    }

    override fun onDraw(canvas: Canvas) {
        circles.forEach {
            canvas.save()
            canvas.translate(it.cX, it.cY)
            canvas.drawCircle(0f, 0f, it.radius, paint)
            canvas.restore()
        }
    }
}
package com.usu.bouncingball

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.Choreographer
import android.view.MotionEvent
import android.view.View

@SuppressLint("ClickableViewAccessibility")
class GameView(context: Context): View(context), Choreographer.FrameCallback  {
    private val choreographer = Choreographer.getInstance()
    private val balls = mutableListOf<Ball>()
    private val paint = Paint()
    private var lastUpdate = System.nanoTime()
    init {
        choreographer.postFrameCallback(this)
        setOnTouchListener { _: View, motionEvent: MotionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                balls.add(Ball(height.toFloat(), motionEvent.x, motionEvent.y))
            }
            return@setOnTouchListener false
        }
    }

    override fun onDraw(canvas: Canvas) {
        balls.forEach { ball ->
            ball.draw(canvas, paint);
        }
    }

    override fun doFrame(delta: Long) {
        // do something here
//        for (ball in balls) {
//            ball.update((delta - lastUpdate) / 1000 / 1000)
//        }
        balls.forEach { ball ->
            ball.update((delta - lastUpdate) / 1000 / 1000)
        }
        lastUpdate = delta
        choreographer.postFrameCallback(this)
        invalidate()
    }
}
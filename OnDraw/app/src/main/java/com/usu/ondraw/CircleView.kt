package com.usu.ondraw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.LinearLayout

class CircleView(context: Context): View(context) {
    private val paint = Paint()
    init {
//        setBackgroundColor(Color.RED)
//        layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200)
    }
    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.translate(width / 2f, height / 2f)
        canvas.rotate(45f)
        canvas.drawRect(
            - 150f,
            - 150f,
            150f,
            150f,
            paint
        )
    }
}
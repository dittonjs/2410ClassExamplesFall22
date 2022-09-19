package com.usu.ondraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }
//        mainLayout.addView(CircleView(this))
        mainLayout.addView(CircleView(this))
        setContentView(mainLayout)
    }
}
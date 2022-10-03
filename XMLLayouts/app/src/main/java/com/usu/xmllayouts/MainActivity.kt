package com.usu.xmllayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        onSaveInstanceState(outState, outPersistentState)
        outState.putInt("count", count)
    }
    override fun onDestroy() {
        super.onDestroy()
        println("I GET CALLED TOO")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("I GET CALLED")
        setContentView(R.layout.activity_main)


        val countDisplay: TextView = findViewById(R.id.counterDisplay)
        count = savedInstanceState!!.getInt("count", 0)
        countDisplay.text = "$count"

        val incrementButton: Button = findViewById(R.id.incrementButton)
//        incrementButton.text = getText(R.string.increment)
        incrementButton.setOnClickListener {
            count ++
            countDisplay.text = "$count"
        }

        val decrementButton: Button = findViewById(R.id.decrementButton)
        decrementButton.setOnClickListener {
            count --
            countDisplay.text = "$count"
        }
    }
}
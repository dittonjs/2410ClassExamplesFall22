package com.usu.layoutparams

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val noteInputLayout = LinearLayout(this).apply {
//            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
//            setBackgroundColor(Color.RED)
        }
        
        //  makePBSandwich

        val noteInputEditText = EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                weight = 1f
            }
        }

        // list of users = [...]
        for (x in 0..listOfUsers.size) {
            // do something with each user
        }

        listOfUsers.forEach({
            // do something with each user
        })




        val button = Button(this).apply {
            setText("<")
            setOnClickListener {
                // does something with the text
            }

            layoutParams = LinearLayout.LayoutParams(100, 100).apply {
//                weight = 1f
            }
        }

        noteInputLayout.apply {
            addView(noteInputEditText)
            addView(button)
        }

        mainLayout.addView(noteInputLayout)

        setContentView(mainLayout)
    }
}
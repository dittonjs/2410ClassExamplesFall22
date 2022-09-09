package com.usu.firstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // java
//        TextView textView = new TextView(this)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val editText = EditText(this)
        val button = Button(this)
        val output = TextView(this)

        button.text = "FUDDIFY"
        button.setOnClickListener {
            // todo fuddify
            val fuddifiedString = editText.text.toString()
                .replace("R", "W", true)
            output.text = fuddifiedString
        }

        layout.addView(editText)
        layout.addView(button)
        layout.addView(output)

        setContentView(layout)
    }
}
// java way
//class Dog {
//    private var name = "Fido"
//    public fun getName(): String {
//        return name
//    }
//
//    public fun setName(name: String) {
//        this.name = name
//    }
//}

//class Dog {
//    var name = "Fido"
//    set(value) {
//        field = value
//    }
//
//    var age = 10
//    set(value) {
//        if (value < 0) {
//            field = 0
//        } else {
//            field = value
//        }
//    }
//}



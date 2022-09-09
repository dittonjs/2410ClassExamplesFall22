package com.usu.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val nameInput = LabelledInput(this, "Name")
        val emailInput = LabelledInput(this, "Email")
        val emailConfirmationInput = LabelledInput(this, "Email Confirmation")
        val passwordInput = LabelledInput(this, "Password")
        val passwordConfirmationInput = LabelledInput(this, "Password Confirmation")

        layout.addView(nameInput)
        layout.addView(emailInput)
        layout.addView(emailConfirmationInput)
        layout.addView(passwordInput)
        layout.addView(passwordConfirmationInput)

        val button = Button(this).apply {
            text = "Press me"
            setOnClickListener {
                nameInput.text
            }
        }

        setContentView(layout)
    }
}
package com.usu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usu.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        binding.textView.text = intent.getStringExtra("myInput")
        setContentView(binding.root)
    }
}
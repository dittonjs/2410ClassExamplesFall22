package com.usu.observerpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usu.observerpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val count = ObservableInt()
        val binding = ActivityMainBinding.inflate(layoutInflater)

        count.observe {
            binding.count.text = "$it"
        }

        binding.decrement.setOnClickListener {
            count.setValue(count.getValue() - 1)
        }
        binding.increment.setOnClickListener {
            count.setValue(count.getValue() + 1)
        }
        setContentView(binding.root)
    }
}
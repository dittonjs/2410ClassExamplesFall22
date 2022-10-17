package com.usu.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usu.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.home.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, HomeFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        binding.profile.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, ProfileFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }
        setContentView(binding.root)
    }
}
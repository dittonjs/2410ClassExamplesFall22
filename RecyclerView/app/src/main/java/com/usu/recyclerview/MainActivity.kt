package com.usu.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.usu.recyclerview.databinding.ActivityMainBinding

data class Contact(
    val name: String,
    val phoneNumber:String,
    val email: String
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val contacts = (0 until 1000000).map {
            Contact("Person ${it}", "${it}", "person$it@usu.edu")
        }.toList()

        binding.recyclerView.adapter = ContactsAdapter(contacts)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val startTime = System.currentTimeMillis()

        val endTime = System.currentTimeMillis()
        println(endTime - startTime)

        setContentView(binding.root)

    }
}
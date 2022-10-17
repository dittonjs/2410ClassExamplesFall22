package com.usu.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.usu.myapplication.databinding.ActivityMainBinding
import com.usu.myapplication.databinding.ActivitySecondBinding
import com.usu.myapplication.databinding.MyGuyBinding
import java.io.Serializable

class Dog(val name: String, val age: Int): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }=
}

"Dog?name=Fido&age=10"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.next.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("myInput", binding.editText.text.toString())
            intent.putExtra()
            startActivity(intent)
        }

        binding.editText.setText ("Start")
        setContentView(binding.root)
    }
}
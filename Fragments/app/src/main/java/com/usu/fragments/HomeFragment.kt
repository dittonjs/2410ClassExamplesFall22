package com.usu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.usu.fragments.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.decrement.setOnClickListener {
            val activity: MainActivity = context as MainActivity
            activity.count --
            binding.count.text = "${activity.count}"
        }

        binding.increment.setOnClickListener {
            val activity: MainActivity = context as MainActivity
            activity.count ++
            binding.count.text = "${activity.count}"
        }
        return binding.root
    }
}
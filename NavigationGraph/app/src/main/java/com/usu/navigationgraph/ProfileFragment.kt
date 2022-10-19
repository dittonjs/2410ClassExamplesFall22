package com.usu.navigationgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usu.navigationgraph.databinding.FragmentHomeBinding
import com.usu.navigationgraph.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.toSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settings)
        }

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}
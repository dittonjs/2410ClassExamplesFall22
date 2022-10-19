package com.usu.navigationgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usu.navigationgraph.databinding.FragmentProfileBinding
import com.usu.navigationgraph.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.toHome.setOnClickListener {
            findNavController().navigate(R.id.action_settings_to_homeFragment)
        }
        return binding.root
    }
}
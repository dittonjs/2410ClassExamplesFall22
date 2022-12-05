package com.usu.todosmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usu.todosmvvm.databinding.FragmentTodoCreationBinding

class TodoCreationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTodoCreationBinding.inflate(inflater, container, false);
        val viewModel = TodoCreationViewModel()
        viewModel.errorMessage.observe(viewLifecycleOwner) {errorMessage ->
            binding.errorOutput.text = errorMessage
        }

        viewModel.done.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigateUp()
            }
        }
        binding.saveButton.setOnClickListener {
            viewModel.createTodo(binding.todoInput.text.toString())
        }
        return binding.root
    }
}
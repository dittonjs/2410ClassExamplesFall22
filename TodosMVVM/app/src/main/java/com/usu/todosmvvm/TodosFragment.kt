package com.usu.todosmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.usu.todosmvvm.databinding.FragmentTodosBinding

class TodosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentTodosBinding.inflate(inflater, container, false)
        val viewModel = TodosViewModel()

        binding.todosList.adapter = TodosAdapter(viewModel.todos)
        binding.todosList.layoutManager = LinearLayoutManager(context)
        viewModel.errorMessage.observe(viewLifecycleOwner) {errorMessage ->
            binding.errorOutput.text = errorMessage
        }
        binding.saveButton.setOnClickListener {
            viewModel.createTodo(binding.todoInput.text.toString())
            binding.todoInput.setText("")
        }
        return binding.root
    }
}
package com.usu.todosmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.usu.todosmvvm.databinding.FragmentTodosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class TodosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTodosBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(TodosViewModel::class.java)

        viewModel.hasError.observe(viewLifecycleOwner) {

        }

        binding.saveButton.setOnClickListener {
            viewModel.createTodo(binding.todoInput.text.toString())
            binding.todoInput.setText("")
        }
        return binding.root
    }
}
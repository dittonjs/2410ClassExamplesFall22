package com.usu.todosmvvm
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        binding.todosList.adapter = TodosAdapter(viewModel.todos) {
            viewModel.toggleTodoCompletion(it)
        }
        binding.todosList.layoutManager = LinearLayoutManager(context)

        binding.createTodo.setOnClickListener {
            findNavController().navigate(R.id.action_todosFragment_to_todoCreationFragment)
        }
        return binding.root
    }
}
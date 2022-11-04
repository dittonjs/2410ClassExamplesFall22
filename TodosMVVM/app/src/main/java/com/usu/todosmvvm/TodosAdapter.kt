package com.usu.todosmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ObservableList.OnListChangedCallback
import androidx.recyclerview.widget.RecyclerView
import com.usu.todosmvvm.databinding.TodoListItemBinding
import com.usu.todosmvvm.models.Todo

class TodosAdapter(val todos: ObservableArrayList<Todo>): RecyclerView.Adapter<TodosAdapter.ViewHolder>() {
    class ViewHolder(val binding: TodoListItemBinding): RecyclerView.ViewHolder(binding.root)


    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.checkBox.text = todo.description
        holder.binding.checkBox.isChecked = todo.completed
        // do some stuff when the user checks a box
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}
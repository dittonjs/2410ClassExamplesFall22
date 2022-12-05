package com.usu.todosmvvm

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usu.todosmvvm.models.Todo
import kotlinx.coroutines.*

var idCounter = 0

class TodosViewModel: ViewModel() {
    val todos = ObservableArrayList<Todo>()
    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            val loadedTodos = TodosRepository.getAllTodos()
            todos.addAll(loadedTodos)
        }
    }

    fun toggleTodoCompletion(todo: Todo) {
        viewModelScope.launch {
            val todoCopy = todo.copy(completed = !todo.completed)
            TodosRepository.update(todoCopy)
            todos[todos.indexOf(todo)] = todoCopy
        }
    }
}
package com.usu.todosmvvm

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usu.todosmvvm.models.Todo

var idCounter = 0

class TodosViewModel: ViewModel() {
    val todos = ObservableArrayList<Todo>()
    val errorMessage = MutableLiveData("")
    fun createTodo(todoInput: String) {
        errorMessage.value = ""
        if (todoInput.isEmpty()) {
            errorMessage.value = "Todo input cannot be blank."
            return
        }
        if(todoInput.trim().isEmpty()) {
            errorMessage.value = "Todo input must contain at least one alpha numerica character"
            return
        }

        // create todo
        todos.add(Todo(idCounter++, todoInput, idCounter % 2 == 0))
    }
}
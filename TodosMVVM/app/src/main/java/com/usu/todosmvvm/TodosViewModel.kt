package com.usu.todosmvvm

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodosViewModel: ViewModel() {
    val hasError = MutableLiveData(false)
    fun createTodo(todoInput: String) {
        hasError.value = false
        if (todoInput.isEmpty()) {
            hasError.value = true
        }
    }
}
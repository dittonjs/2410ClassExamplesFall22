package com.usu.todosmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usu.todosmvvm.models.Todo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TodoCreationViewModel: ViewModel() {
    val errorMessage = MutableLiveData("")
    val done = MutableLiveData(false)

    fun createTodo(todoInput: String) {
        errorMessage.value = ""
        if (todoInput.isEmpty()) {
            errorMessage.value = "Todo input cannot be blank."
            viewModelScope.launch {
                delay(3000)
                errorMessage.value = ""
            }
            return
        }
        if(todoInput.trim().isEmpty()) {
            errorMessage.value = "Todo input must contain at least one alpha numerica character"
            return
        }

        // create todo
        viewModelScope.launch {
            val todo = Todo(id = 0, description = todoInput, completed = false)
            TodosRepository.createTodo(todo);
            done.value = true
        }

    }
}
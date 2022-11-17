package com.usu.todosmvvm

import androidx.room.Room
import com.usu.todosmvvm.models.Todo

object TodosRepository {
    private val db: AppDatabase;
    init {
        db = Room.databaseBuilder(
            TodosApplication.getInstance(),
            AppDatabase::class.java,
            "todos-database"
        ).build()
    }

    suspend fun createTodo(todo: Todo): Long {
        return db.getTodosDao().createTodo(todo)
    }

    suspend fun getAllTodos(): List<Todo> {
        return db.getTodosDao().getAllTodos()
    }

    suspend fun update(todo: Todo) {
        db.getTodosDao().updateTodo(todo)
    }

}

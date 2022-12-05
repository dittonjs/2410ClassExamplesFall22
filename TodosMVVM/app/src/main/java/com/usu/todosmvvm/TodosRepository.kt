package com.usu.todosmvvm

import androidx.room.Room
import com.usu.todosmvvm.models.Todo

object TodosRepository {
    private val db: AppDatabase;
    private var cacheInitialized = false;
    private val todosCache = mutableListOf<Todo>()
    init {
        db = Room.databaseBuilder(
            TodosApplication.getInstance(),
            AppDatabase::class.java,
            "todos-database"
        ).build()
    }

    suspend fun createTodo(todo: Todo) {
        todo.id = db.getTodosDao().createTodo(todo)
        todosCache.add(todo)
    }

    suspend fun getAllTodos(): List<Todo> {
        if (!cacheInitialized) {
            todosCache.addAll(db.getTodosDao().getAllTodos())
            cacheInitialized = true
        }
        return todosCache
    }

    suspend fun update(todo: Todo) {
        db.getTodosDao().updateTodo(todo)
        todosCache[todosCache.indexOfFirst {
            it.id == todo.id
        }] = todo
    }

}

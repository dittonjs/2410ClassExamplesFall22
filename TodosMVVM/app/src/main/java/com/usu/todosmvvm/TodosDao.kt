package com.usu.todosmvvm

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.usu.todosmvvm.models.Todo

@Dao
interface TodosDao {
    @Query("SELECT * FROM todo")
    suspend fun getAllTodos(): List<Todo>

    @Insert
    suspend fun createTodo(todo: Todo): Long

    @Update
    suspend fun updateTodo(todo: Todo)

//    @Insert
//    suspend fun createMany(vararg todos: List<Todo>)
}
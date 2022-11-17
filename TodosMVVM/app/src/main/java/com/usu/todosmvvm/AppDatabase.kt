package com.usu.todosmvvm

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usu.todosmvvm.models.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getTodosDao(): TodosDao
}
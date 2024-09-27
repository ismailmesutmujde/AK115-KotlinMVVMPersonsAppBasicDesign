package com.ismailmesutmujde.kotlinpersonsappbasicdesign.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons

@Database(entities = [Persons::class], version = 1)
abstract class RoomDb : RoomDatabase() {
    abstract fun getPersonsDao() : PersonsDao
}
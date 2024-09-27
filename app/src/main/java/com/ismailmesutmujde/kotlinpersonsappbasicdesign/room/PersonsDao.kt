package com.ismailmesutmujde.kotlinpersonsappbasicdesign.room

import androidx.room.*
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons")
    suspend fun allPersons() : List<Persons>

    @Query("SELECT * FROM persons Where person_name like '%' || :searchingWord || '%'")
    suspend fun searchPerson(searchingWord:String) : List<Persons>

    @Insert
    suspend fun insertPerson(person:Persons)

    @Update
    suspend fun updatePerson(person:Persons)

    @Delete
    suspend fun deletePerson(person:Persons)
}
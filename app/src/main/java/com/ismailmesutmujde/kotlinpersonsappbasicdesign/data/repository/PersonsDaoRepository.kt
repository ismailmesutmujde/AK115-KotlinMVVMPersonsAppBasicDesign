package com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.room.PersonsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonsDaoRepository(var pdao : PersonsDao) {

    var personsList : MutableLiveData<List<Persons>>

    init {
        personsList = MutableLiveData()
    }

    fun getPersons() : MutableLiveData<List<Persons>> {
        return personsList
    }

    fun personRecord(person_name:String, person_phone:String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0, person_name,person_phone)
            pdao.insertPerson(newPerson)
        }
        Log.e("Person Record", "${person_name} - ${person_phone}")
    }

    fun personUpdate(person_id:Int, person_name:String, person_phone:String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Persons(person_id, person_name, person_phone)
            pdao.updatePerson(updatedPerson)
        }
        Log.e("Person Update", "${person_id} - ${person_name} - ${person_phone}")
    }

    fun personSearch(searchingWord:String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.searchPerson(searchingWord)
        }
        Log.e("Person Search", searchingWord)
    }

    fun personDelete(person_id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Persons(person_id, "", "")
            pdao.deletePerson(deletedPerson)
            getAllPersons()
        }
        Log.e("Person Delete", person_id.toString())
    }

    fun getAllPersons() {
        /*
        val list = ArrayList<Persons>()
        val p1 = Persons(1, "Ahmet","111111")
        val p2 = Persons(2, "Zeynep","222222")
        val p3 = Persons(3, "Beyza","333333")
        val p4 = Persons(4, "Ece","444444")
        val p5 = Persons(5, "Gamze","555555")
        val p6 = Persons(6, "Mehmet","666666")
        val p7 = Persons(7,"İsmail","777777")
        val p8 = Persons(8, "Hüseyin","888888")
        val p9 = Persons(9, "Caner","999999")
        val p10 = Persons(10, "Özlem","101010")
        list.add(p1)
        list.add(p2)
        list.add(p3)
        list.add(p4)
        list.add(p5)
        list.add(p6)
        list.add(p7)
        list.add(p8)
        list.add(p9)
        list.add(p10)
        personsList.value = list*/

        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.allPersons()
        }
    }
}
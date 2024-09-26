package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository

class MainScreenViewModel : ViewModel() {

    val pRepo = PersonsDaoRepository()
    var personsList = MutableLiveData<List<Persons>>()

    init {
        loadingPersons()
        personsList = pRepo.getPersons()
    }

    fun search(searchingWord:String) {
        pRepo.personSearch(searchingWord)
    }

    fun delete(person_id: Int) {
        pRepo.personDelete(person_id)
    }

    fun loadingPersons() {
        pRepo.getAllPersons()
    }
}
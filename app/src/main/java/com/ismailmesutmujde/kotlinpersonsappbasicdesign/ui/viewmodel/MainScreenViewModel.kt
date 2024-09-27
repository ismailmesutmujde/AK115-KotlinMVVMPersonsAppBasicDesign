package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(var pRepo : PersonsDaoRepository) : ViewModel() {

    var personsList = MutableLiveData<List<Persons>>()

    init {
        loadingPersons()
        personsList = pRepo.getPersons()
    }

    fun search(searchingWord:String) {
        pRepo.personSearch(searchingWord)
    }

    fun delete(person_id: String) {
        pRepo.personDelete(person_id)
    }

    fun loadingPersons() {
        pRepo.getAllPersons()
    }
}
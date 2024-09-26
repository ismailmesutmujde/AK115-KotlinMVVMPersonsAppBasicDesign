package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel


import androidx.lifecycle.ViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonRecordScreenViewModel @Inject constructor(var pRepo : PersonsDaoRepository) : ViewModel() {

    fun record(person_name:String, person_phone:String) {
        pRepo.personRecord(person_name, person_phone)
    }
}
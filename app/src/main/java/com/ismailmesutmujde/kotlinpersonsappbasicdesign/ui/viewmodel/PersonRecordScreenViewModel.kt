package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository

class PersonRecordScreenViewModel : ViewModel() {

    val pRepo = PersonsDaoRepository()

    fun record(person_name:String, person_phone:String) {
        pRepo.personRecord(person_name, person_phone)
    }
}
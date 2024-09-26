package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository

class PersonDetailScreenViewModel : ViewModel() {

    val pRepo = PersonsDaoRepository()

    fun update(person_id:Int, person_name:String, person_phone:String) {
        pRepo.personUpdate(person_id, person_name, person_phone)
    }
}
package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonDetailScreenViewModel @Inject constructor(var pRepo : PersonsDaoRepository) : ViewModel() {

    fun update(person_id:Int, person_name:String, person_phone:String) {
        pRepo.personUpdate(person_id, person_name, person_phone)
    }
}
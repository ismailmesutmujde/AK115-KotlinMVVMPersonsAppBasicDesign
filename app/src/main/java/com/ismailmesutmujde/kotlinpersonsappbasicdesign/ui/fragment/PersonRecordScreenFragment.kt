package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.R
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentPersonRecordScreenBinding
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel.PersonRecordScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonRecordScreenFragment : Fragment() {

    private lateinit var bindingPersonRecordScreen : FragmentPersonRecordScreenBinding
    private lateinit var viewModelPersonRecordScreen : PersonRecordScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingPersonRecordScreen = DataBindingUtil.inflate(inflater, R.layout.fragment_person_record_screen, container, false)

        bindingPersonRecordScreen.personRecordFragment = this
        bindingPersonRecordScreen.personRecordToolbarTitle = "Person Record"

        return bindingPersonRecordScreen.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonRecordScreenViewModel by viewModels()
        viewModelPersonRecordScreen = tempViewModel
    }

    fun buttonSave(person_name:String, person_phone:String) {
        viewModelPersonRecordScreen.record(person_name, person_phone)
    }

}
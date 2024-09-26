package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.R
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentPersonRecordScreenBinding

class PersonRecordScreenFragment : Fragment() {

    private lateinit var bindingPersonRecordScreen : FragmentPersonRecordScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingPersonRecordScreen = DataBindingUtil.inflate(inflater, R.layout.fragment_person_record_screen, container, false)

        bindingPersonRecordScreen.personRecordFragment = this
        bindingPersonRecordScreen.personRecordToolbarTitle = "Person Record"

        return bindingPersonRecordScreen.root
    }

    fun buttonSave(person_name:String, person_phone:String) {
        Log.e("Person Record", "${person_name} - ${person_phone}")
    }

}
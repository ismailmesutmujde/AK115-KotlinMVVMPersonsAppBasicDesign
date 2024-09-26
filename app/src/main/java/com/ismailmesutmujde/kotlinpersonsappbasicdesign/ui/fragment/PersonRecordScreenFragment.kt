package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentPersonRecordScreenBinding

class PersonRecordScreenFragment : Fragment() {

    private lateinit var bindingPersonRecordScreen : FragmentPersonRecordScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingPersonRecordScreen = FragmentPersonRecordScreenBinding.inflate(inflater, container, false)

        bindingPersonRecordScreen.toolbarPersonRecordScreen.title = "Person Record"

        bindingPersonRecordScreen.buttonSave.setOnClickListener {
            val person_name = bindingPersonRecordScreen.editTextPersonName.text.toString()
            val person_phone = bindingPersonRecordScreen.editTextPersonPhone.text.toString()

            record(person_name,person_phone)
        }
        return bindingPersonRecordScreen.root
    }

    fun record(person_name:String, person_phone:String) {
        Log.e("Person Record", "${person_name} - ${person_phone}")
    }

}
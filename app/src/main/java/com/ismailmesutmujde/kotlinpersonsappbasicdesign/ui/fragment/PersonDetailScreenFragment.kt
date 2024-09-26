package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentPersonDetailScreenBinding

class PersonDetailScreenFragment : Fragment() {

    private lateinit var bindingPersonDetailScree : FragmentPersonDetailScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingPersonDetailScree = FragmentPersonDetailScreenBinding.inflate(inflater, container, false)

        bindingPersonDetailScree.toolbarPersonDetailScreen.title = "Person Detail"
        val bundle: PersonDetailScreenFragmentArgs by navArgs()
        val incomingPerson = bundle.person

        bindingPersonDetailScree.editTextUpdatePersonName.setText(incomingPerson.person_name)
        bindingPersonDetailScree.editTextUpdatePersonPhone.setText(incomingPerson.person_phone)

        bindingPersonDetailScree.buttonUpdate.setOnClickListener {
            val person_name = bindingPersonDetailScree.editTextUpdatePersonName.text.toString()
            val person_phone = bindingPersonDetailScree.editTextUpdatePersonPhone.text.toString()

            update(incomingPerson.person_id, person_name, person_phone)
        }
        return bindingPersonDetailScree.root
    }

    fun update(person_id:Int, person_name:String, person_phone:String) {
        Log.e("Person Record", "${person_id} - ${person_name} - ${person_phone}")
    }


}
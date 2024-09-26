package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.R
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentPersonDetailScreenBinding

class PersonDetailScreenFragment : Fragment() {

    private lateinit var bindingPersonDetailScree : FragmentPersonDetailScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingPersonDetailScree = DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail_screen,container, false)

        bindingPersonDetailScree.personDetailFragment = this
        bindingPersonDetailScree.personDetailToolbarTitle = "Person Detail"

        val bundle: PersonDetailScreenFragmentArgs by navArgs()
        val incomingPerson = bundle.person

        bindingPersonDetailScree.personObject = incomingPerson

        return bindingPersonDetailScree.root
    }

    fun buttonUpdate(person_id:Int, person_name:String, person_phone:String) {
        Log.e("Person Record", "${person_id} - ${person_name} - ${person_phone}")
    }


}
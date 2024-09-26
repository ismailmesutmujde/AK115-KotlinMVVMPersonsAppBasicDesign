package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.PersonCardDesignBinding
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment.MainScreenFragmentDirections

class PersonsRecyclerViewAdapter(private val mContext : Context,
                                 private var personsList : List<Persons>)
    : RecyclerView.Adapter<PersonsRecyclerViewAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design : PersonCardDesignBinding) : RecyclerView.ViewHolder(design.root) {
        var design:PersonCardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = PersonCardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return personsList.size
    }


    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personsList.get(position)
        val d = holder.design

        d.textViewPersonInfo.text = "${person.person_name} - ${person.person_phone}"

        d.personCard.setOnClickListener {
            val transition = MainScreenFragmentDirections.actionMainScreenFragmentToPersonDetailScreenFragment(person = person)
            Navigation.findNavController(it).navigate(transition)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Delete ${person.person_name}?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    Log.e("Person Delete", person.person_id.toString())
                }.show()

        }
    }
}
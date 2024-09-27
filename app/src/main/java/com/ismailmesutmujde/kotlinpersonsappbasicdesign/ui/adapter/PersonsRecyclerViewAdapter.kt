package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.R
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.PersonCardDesignBinding
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment.MainScreenFragmentDirections
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel.MainScreenViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.util.makeTransition

class PersonsRecyclerViewAdapter(private val mContext : Context,
                                 private var personsList : List<Persons>,
                                 var viewModelMainScreen : MainScreenViewModel)
    : RecyclerView.Adapter<PersonsRecyclerViewAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design : PersonCardDesignBinding) : RecyclerView.ViewHolder(design.root) {
        var design:PersonCardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design :PersonCardDesignBinding = DataBindingUtil.inflate(layoutInflater, R.layout.person_card_design, parent, false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return personsList.size
    }


    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personsList.get(position)
        val d = holder.design

        d.personObject = person

        d.personCard.setOnClickListener {

            val transition = MainScreenFragmentDirections.actionMainToPersonDetail(person = person)
            Navigation.makeTransition(it, transition)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Delete ${person.person_name}?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    viewModelMainScreen.delete(person.person_id!!)
                }.show()

        }
    }
}
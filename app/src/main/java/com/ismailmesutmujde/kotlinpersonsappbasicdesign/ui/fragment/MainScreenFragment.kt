package com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.R
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentMainScreenBinding
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.adapter.PersonsRecyclerViewAdapter

class MainScreenFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var bindingMainScreen : FragmentMainScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingMainScreen = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)
        bindingMainScreen.mainScreenFragment = this

        bindingMainScreen.mainScreenToolbarTitle = "Persons"
        (activity as AppCompatActivity).setSupportActionBar(bindingMainScreen.toolbarMainScreen)

        val personList = ArrayList<Persons>()
        val p1 = Persons(1, "Ahmet","111111")
        val p2 = Persons(2, "Zeynep","222222")
        val p3 = Persons(3, "Beyza","333333")
        val p4 = Persons(4, "Ece","444444")
        val p5 = Persons(5, "Gamze","555555")
        val p6 = Persons(6, "Mehmet","666666")
        val p7 = Persons(7,"İsmail","777777")
        val p8 = Persons(8, "Hüseyin","888888")
        val p9 = Persons(9, "Caner","999999")
        val p10 = Persons(10, "Özlem","101010")

        personList.add(p1)
        personList.add(p2)
        personList.add(p3)
        personList.add(p4)
        personList.add(p5)
        personList.add(p6)
        personList.add(p7)
        personList.add(p8)
        personList.add(p9)
        personList.add(p10)

        val adapter = PersonsRecyclerViewAdapter(requireContext(), personList)
        bindingMainScreen.personsRecyclerViewAdapter = adapter

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainScreenFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return bindingMainScreen.root
    }

    fun fabClick(it:View) {
        Navigation.findNavController(it).navigate(R.id.action_mainScreenFragment_to_personRecordScreenFragment)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        Log.e("Sent Search", query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        Log.e("As Letters Enter", newText)
        return true
    }

    fun search(searchingWord:String) {
        Log.e("Person Search", searchingWord)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Persons Main Screen", "Returned")
    }
}
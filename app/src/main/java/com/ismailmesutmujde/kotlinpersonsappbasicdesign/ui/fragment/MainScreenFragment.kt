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
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.R
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.databinding.FragmentMainScreenBinding
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.adapter.PersonsRecyclerViewAdapter
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.viewmodel.MainScreenViewModel
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.util.makeTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var bindingMainScreen : FragmentMainScreenBinding
    private lateinit var viewModelMainScreen : MainScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingMainScreen = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)
        bindingMainScreen.mainScreenFragment = this

        bindingMainScreen.mainScreenToolbarTitle = "Persons"
        (activity as AppCompatActivity).setSupportActionBar(bindingMainScreen.toolbarMainScreen)

        viewModelMainScreen.personsList.observe(viewLifecycleOwner) {
            val adapter = PersonsRecyclerViewAdapter(requireContext(), it, viewModelMainScreen)
            bindingMainScreen.personsRecyclerViewAdapter = adapter
        }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainScreenViewModel by viewModels()
        viewModelMainScreen = tempViewModel
    }

    fun fabClick(it:View) {
        Navigation.makeTransition(it,R.id.action_main_to_personRecord)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModelMainScreen.search(query)
        Log.e("Sent Search", query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModelMainScreen.search(newText)
        Log.e("As Letters Enter", newText)
        return true
    }

    /*
    override fun onResume() {
        super.onResume()
        viewModelMainScreen.loadingPersons()
    }*/
}
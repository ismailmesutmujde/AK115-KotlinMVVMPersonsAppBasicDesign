package com.ismailmesutmujde.kotlinpersonsappbasicdesign.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.makeTransition(it:View, id:Int) {
    findNavController(it).navigate(id)
}

fun Navigation.makeTransition(it:View, id: NavDirections) {
    findNavController(it).navigate(id)
}
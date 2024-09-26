package com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity

import java.io.Serializable

data class Persons (var person_id : Int, var person_name : String, var person_phone : String) : Serializable {
}
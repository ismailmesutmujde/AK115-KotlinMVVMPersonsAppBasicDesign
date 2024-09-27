package com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity

import com.google.gson.annotations.SerializedName

data class PersonsResponse (@SerializedName("kisiler") var persons:List<Persons>,
                            @SerializedName("success") var success:Int) {

}
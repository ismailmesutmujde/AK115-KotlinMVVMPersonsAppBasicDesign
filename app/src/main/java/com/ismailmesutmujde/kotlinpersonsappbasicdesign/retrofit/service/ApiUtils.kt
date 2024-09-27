package com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit.service

import com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit.PersonsDaoInterface
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit.RetrofitClient

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getPersonsDaoInterface() : PersonsDaoInterface {
            return  RetrofitClient.getClient(BASE_URL).create(PersonsDaoInterface::class.java)
        }

    }
}
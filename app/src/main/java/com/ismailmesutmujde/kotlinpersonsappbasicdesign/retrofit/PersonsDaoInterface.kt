package com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit

import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.CRUDResponse
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.PersonsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonsDaoInterface {
    // http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

    @GET("kisiler/tum_kisiler.php")
    fun allPersons():Call<PersonsResponse>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun searchPerson(@Field("kisi_ad") person_name : String) : Call<PersonsResponse>

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun deletePerson(@Field("kisi_id") person_id:Int) : Call<CRUDResponse>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun insertPerson(@Field("kisi_ad") person_name:String,
                     @Field("kisi_tel") person_phone:String) : Call<CRUDResponse>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun updatePerson(@Field("kisi_id") person_id:Int,
                     @Field("kisi_ad") person_name:String,
                     @Field("kisi_tel") person_phone:String) : Call<CRUDResponse>
}
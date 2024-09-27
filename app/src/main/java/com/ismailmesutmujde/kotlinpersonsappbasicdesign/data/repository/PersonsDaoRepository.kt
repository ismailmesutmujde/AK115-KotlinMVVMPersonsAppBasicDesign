package com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.CRUDResponse
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.Persons
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity.PersonsResponse
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit.PersonsDaoInterface
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.ui.adapter.PersonsRecyclerViewAdapter
//import com.ismailmesutmujde.kotlinpersonsappbasicdesign.room.PersonsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// this code for retrofit
// class PersonsDaoRepository(var pdao : PersonsDaoInterface)
// this code for room
// class PersonsDaoRepository(var pdao : PersonsDao)
class PersonsDaoRepository(var refPersons:DatabaseReference) {

    var personsList : MutableLiveData<List<Persons>>

    init {
        personsList = MutableLiveData()
    }

    fun getPersons() : MutableLiveData<List<Persons>> {
        return personsList
    }

    fun personInsert(person_name:String, person_phone:String) {

        // this code for firebase
        val newPerson = Persons("", person_name, person_phone)
        refPersons.push().setValue(newPerson)

        /* this code for retrofit
        pdao.insertPerson(person_name, person_phone).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                val success = response.body()!!.success
                val message = response.body()!!.message
                Log.e("Person Insert", "$success - $message")
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }

        })*/

        /* this code for room
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0, person_name,person_phone)
            pdao.insertPerson(newPerson)
        }*/
        Log.e("Person Insert", "${person_name} - ${person_phone}")
    }

    fun personUpdate(person_id:String, person_name:String, person_phone:String) {

        // this code for firebase
        val infoPerson = HashMap<String, Any>()
        infoPerson.put("person_name", person_name)
        infoPerson.put("person_phone", person_phone)
        refPersons.child(person_id!!).updateChildren(infoPerson)

        /* this code for retrofit
        pdao.updatePerson(person_id, person_name, person_phone).enqueue(object :
            Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                val success = response.body()!!.success
                val message = response.body()!!.message
                Log.e("Person Update", "$success - $message")
                getAllPersons()
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }

        })*/

        /* this code for room
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Persons(person_id, person_name, person_phone)
            pdao.updatePerson(updatedPerson)
        }*/
        Log.e("Person Update", "${person_id} - ${person_name} - ${person_phone}")
    }

    fun personSearch(searchingWord:String) {

        // this code for firebase
        refPersons.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Persons>()

                for(c in snapshot.children) {
                    val person = c.getValue(Persons::class.java)
                    if(person != null) {
                        if (person.person_name!!.lowercase().contains(searchingWord.lowercase())){
                            person.person_id = c.key
                            list.add(person)
                        }
                    }
                }
                personsList.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        /* this code for retrofit
        pdao.searchPerson(searchingWord).enqueue(object: Callback<PersonsResponse> {
            override fun onResponse(call: Call<PersonsResponse>, response: Response<PersonsResponse>) {
                val list = response.body()!!.persons
                personsList.value = list
            }

            override fun onFailure(call: Call<PersonsResponse>, t: Throwable) {

            }
        })*/

        /* this code for room
        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.searchPerson(searchingWord)
        }*/
        Log.e("Person Search", searchingWord)
    }

    fun personDelete(person_id: String) {

        // this code for firebase
        refPersons.child(person_id!!).removeValue()

        /* this code for retrofit
        pdao.deletePerson(person_id).enqueue(object :
            Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                val success = response.body()!!.success
                val message = response.body()!!.message
                Log.e("Person Delete", "$success - $message")
                getAllPersons()

            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }

        })*/

        /* this code for room
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Persons(person_id, "", "")
            pdao.deletePerson(deletedPerson)
            getAllPersons()
        }*/

        Log.e("Person Delete", person_id.toString())
    }

    fun getAllPersons() {

        // this code for firebase
        refPersons.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val list = ArrayList<Persons>()

                for(c in snapshot.children) {
                    val person = c.getValue(Persons::class.java)
                    if(person != null) {
                        person.person_id = c.key
                        list.add(person)
                    }
                }
                personsList.value = list
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        /* this code for retrofit
        pdao.allPersons().enqueue(object: Callback<PersonsResponse>{
            override fun onResponse(call: Call<PersonsResponse>, response: Response<PersonsResponse>) {
                val list = response.body()!!.persons
                personsList.value = list
            }

            override fun onFailure(call: Call<PersonsResponse>, t: Throwable) {

            }
        })*/


        /* this code for room
        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.allPersons()
        }*/


        /* local dataset
        val list = ArrayList<Persons>()
        val p1 = Persons("1", "Ahmet","111111")
        val p2 = Persons("2", "Zeynep","222222")
        val p3 = Persons("3", "Beyza","333333")
        val p4 = Persons("4", "Ece","444444")
        val p5 = Persons("5", "Gamze","555555")
        val p6 = Persons("6", "Mehmet","666666")
        val p7 = Persons("7","İsmail","777777")
        val p8 = Persons("8", "Hüseyin","888888")
        val p9 = Persons("9", "Caner","999999")
        val p10 = Persons("10", "Özlem","101010")
        list.add(p1)
        list.add(p2)
        list.add(p3)
        list.add(p4)
        list.add(p5)
        list.add(p6)
        list.add(p7)
        list.add(p8)
        list.add(p9)
        list.add(p10)
        personsList.value = list*/
    }
}
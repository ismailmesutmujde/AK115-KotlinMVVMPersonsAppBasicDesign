package com.ismailmesutmujde.kotlinpersonsappbasicdesign.di

import android.content.Context
//import androidx.room.Room
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit.PersonsDaoInterface
import com.ismailmesutmujde.kotlinpersonsappbasicdesign.retrofit.service.ApiUtils
//import com.ismailmesutmujde.kotlinpersonsappbasicdesign.room.RoomDb
//import com.ismailmesutmujde.kotlinpersonsappbasicdesign.room.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePersonsDaoRepository(pdao:PersonsDaoInterface) : PersonsDaoRepository {
        return PersonsDaoRepository(pdao)
    }

    @Provides
    @Singleton
    fun providePersonsDao() : PersonsDaoInterface {
        return ApiUtils.getPersonsDaoInterface()
    }


    /* these codes are for the room
    @Provides
    @Singleton
    fun providePersonsDaoRepository(pdao:PersonsDao) : PersonsDaoRepository {
        return PersonsDaoRepository(pdao)
    }

    @Provides
    @Singleton
    fun providePersonsDao(@ApplicationContext mContext: Context) : PersonsDao {
        val db = Room.databaseBuilder(mContext, RoomDb::class.java, "guide.sqlite").createFromAsset("guide.sqlite").build()
        return db.getPersonsDao()
    }*/
}
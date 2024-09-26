package com.ismailmesutmujde.kotlinpersonsappbasicdesign.dependencyinjection

import com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.repository.PersonsDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonsDaoRepository() : PersonsDaoRepository {
        return PersonsDaoRepository()
    }
}
package com.techun.pomodoro.di

import com.techun.pomodoro.data.firebase.BaseAuthRepository
import com.techun.pomodoro.data.firebase.BaseAuthenticator
import com.techun.pomodoro.data.firebase.FirebaseAuthenticator
import com.techun.pomodoro.data.firebase.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    //this means that anytime we need an authenticator Dagger will provide a Firebase authenticator.
    //in future if you want to swap out Firebase authentication for your own custom authenticator
    //you will simply come and swap here.
    @Singleton
    @Provides
    fun provideAuthenticator(): BaseAuthenticator {
        return FirebaseAuthenticator()
    }

    //this just takes the same idea as the authenticator. If we create another repository class
    //we can simply just swap here
    @Singleton
    @Provides
    fun provideRepository(authenticator: BaseAuthenticator): BaseAuthRepository {
        return AuthRepository(authenticator)
    }
}
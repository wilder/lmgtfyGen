package com.wilderpereira.lmgtfygen.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule(val application: Application){

    @Provides
    @Singleton
    fun getTextProvider() = application.resources
}
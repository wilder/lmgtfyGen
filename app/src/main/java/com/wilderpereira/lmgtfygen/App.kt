package com.wilderpereira.lmgtfygen

import android.app.Application

import com.wilderpereira.lmgtfygen.dagger.component.DaggerMainComponent
import com.wilderpereira.lmgtfygen.dagger.component.MainComponent

/**
 * Created by Wilder on 24/01/17.
 */

class App : Application() {

    lateinit var component: MainComponent
    private set

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component = DaggerMainComponent
                .builder()
                .build()
    }
}

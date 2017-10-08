package com.wilderpereira.lmgtfygen.dagger.component

import com.wilderpereira.lmgtfygen.dagger.module.NetworkModule
import com.wilderpereira.lmgtfygen.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Wilder on 25/01/17.
 */
@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}

package com.wilderpereira.lmgtfygen.dagger.component

import com.wilderpereira.lmgtfygen.dagger.module.NetworkModule
import com.wilderpereira.lmgtfygen.dagger.module.PresenterModule
import com.wilderpereira.lmgtfygen.presentation.MainActivity
import com.wilderpereira.lmgtfygen.presentation.MainPresenter

import javax.inject.Singleton

import dagger.Component

/**
 * Created by Wilder on 25/01/17.
 */
@Singleton
@Component(modules = arrayOf(NetworkModule::class, PresenterModule::class))

interface MainComponent {
    fun inject(activity: MainActivity)
    fun inject(presenter: MainPresenter)
}

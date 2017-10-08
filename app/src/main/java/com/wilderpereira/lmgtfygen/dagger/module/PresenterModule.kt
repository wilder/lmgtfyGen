package com.wilderpereira.lmgtfygen.dagger.module

import com.wilderpereira.lmgtfygen.presentation.MainContract
import com.wilderpereira.lmgtfygen.presentation.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Wilder on 31/01/17.
 */

@Module
open class PresenterModule {

    @Singleton
    @Provides
    internal fun providesPresenter(mainPresenter: MainPresenter): MainContract.Presenter = mainPresenter
}

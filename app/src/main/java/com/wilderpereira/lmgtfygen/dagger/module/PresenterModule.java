package com.wilderpereira.lmgtfygen.dagger.module;

import com.wilderpereira.lmgtfygen.presentation.MainContract;
import com.wilderpereira.lmgtfygen.presentation.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wilder on 31/01/17.
 */

@Module
public class PresenterModule {

    @Singleton
    @Provides
    MainContract.Presenter providesPresenter(){
        return new MainPresenter();
    }
}

package com.wilderpereira.lmgtfygen.dagger.module;

import com.wilderpereira.lmgtfygen.presentation.MainContract;
import com.wilderpereira.lmgtfygen.presentation.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wilder on 25/01/17.
 */

@Module
public class PresenterModule {

    @Provides
    MainContract.Presenter providesPresenter(){
        return new MainPresenter();
    }
}

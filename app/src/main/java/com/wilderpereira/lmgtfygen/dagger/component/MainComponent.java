package com.wilderpereira.lmgtfygen.dagger.component;

import com.wilderpereira.lmgtfygen.dagger.module.NetworkModule;
import com.wilderpereira.lmgtfygen.dagger.module.PresenterModule;
import com.wilderpereira.lmgtfygen.presentation.MainActivity;
import com.wilderpereira.lmgtfygen.presentation.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Wilder on 25/01/17.
 */
@Singleton
@Component(modules = {NetworkModule.class, PresenterModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(MainPresenter presenter);
}

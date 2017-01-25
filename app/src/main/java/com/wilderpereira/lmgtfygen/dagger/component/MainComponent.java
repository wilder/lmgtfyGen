package com.wilderpereira.lmgtfygen.dagger.component;

import com.wilderpereira.lmgtfygen.dagger.module.NetworkModule;
import com.wilderpereira.lmgtfygen.dagger.module.PresenterModule;
import com.wilderpereira.lmgtfygen.dagger.module.SettingsModule;
import com.wilderpereira.lmgtfygen.presentation.MainActivity;

import dagger.Component;

/**
 * Created by Wilder on 25/01/17.
 */
@Component(modules = {NetworkModule.class, PresenterModule.class, SettingsModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}

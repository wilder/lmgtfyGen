package com.wilderpereira.lmgtfygen;

import android.app.Application;

import com.wilderpereira.lmgtfygen.dagger.component.DaggerMainComponent;
import com.wilderpereira.lmgtfygen.dagger.component.MainComponent;

/**
 * Created by Wilder on 24/01/17.
 */

public class App extends Application {

    private static MainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        component = DaggerMainComponent
                .builder()
                .build();
    }

    public static MainComponent getComponent() {
        return component;
    }
}

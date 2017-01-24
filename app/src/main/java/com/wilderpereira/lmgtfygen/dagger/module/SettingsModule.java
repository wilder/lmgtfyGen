package com.wilderpereira.lmgtfygen.dagger.module;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wilder on 24/01/17.
 */

@Module
public class SettingsModule {

    public static final String BASE_URL = "Settings.ShortenerApiUrl";

    @Provides
    @Singleton
    @Named(BASE_URL)
    String providesServerUrl(Context context) {
        return "https://www.googleapis.com/urlshortener/v1/url";
    }
}

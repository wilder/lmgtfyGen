package com.wilderpereira.lmgtfygen.domain.repository;

import com.wilderpereira.lmgtfygen.domain.entity.ShortenerResponse;

import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Wilder on 30/01/17.
 */

public interface GoogleShortenerApi {
    @POST("url")
    Observable<ShortenerResponse> shortenUrl(@Field("longUrl")  String longUrl, @Field("key") String key);
}

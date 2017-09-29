package com.wilderpereira.lmgtfygen.domain.repository

import com.wilderpereira.lmgtfygen.domain.entity.SearchUrl
import com.wilderpereira.lmgtfygen.domain.entity.ShortenerBody

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Wilder on 30/01/17.
 */

interface UrlShortenerApi {
    @POST("url")
    fun shortenUrl(@Query("key") key: String, @Body body: ShortenerBody): Observable<SearchUrl>
}

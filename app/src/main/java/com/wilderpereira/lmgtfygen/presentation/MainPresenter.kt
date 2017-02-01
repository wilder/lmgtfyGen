package com.wilderpereira.lmgtfygen.presentation

import android.util.Log
import com.wilderpereira.lmgtfygen.App
import com.wilderpereira.lmgtfygen.domain.entity.ShortenerBody
import com.wilderpereira.lmgtfygen.domain.repository.UrlShortenerApi
import retrofit2.Retrofit
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Wilder on 22/01/17.
 */
class MainPresenter : MainContract.Presenter  {

    lateinit var view : MainContract.View
    @Inject lateinit var retrofit: Retrofit


    val TYPE_REGEX = "(?<=t=)\\w*".toRegex()
    val SEARCH_REGEX = "(?<=q=).*$".toRegex()

    constructor(){
        App.getComponent().inject(this)
    }


    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun updateSearchType(type: String, url: CharSequence) {
        view.updateGeneratedUrl(url.replace(TYPE_REGEX, type[0].toLowerCase().toString()))
    }

    override fun updateSearchValue(searchValue: String, url: CharSequence){
        view.updateGeneratedUrl(url.replace(SEARCH_REGEX, searchValue))
    }

    override fun shortenUrl(bigUrl: String) {
        var urlShortener = retrofit.create(UrlShortenerApi::class.java)

        var shortenResponse = urlShortener.shortenUrl(
                "AIzaSyBuf8pcNO7fiAuulkP0UVB-VfBZ3Pa1F6I", ShortenerBody(bigUrl))
        shortenResponse.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ shortenResponse ->
                    view.updateGeneratedUrl(shortenResponse.shortUrl.toString())
                },
                        { e ->
                            Log.d("mainpresenter", "error "+e.message)
                        })
    }

}

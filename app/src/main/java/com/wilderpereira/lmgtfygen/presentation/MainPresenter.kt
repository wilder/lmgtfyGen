package com.wilderpereira.lmgtfygen.presentation

import android.content.Context
import android.util.Log
import com.wilderpereira.lmgtfygen.R
import com.wilderpereira.lmgtfygen.domain.entity.SearchUrl
import com.wilderpereira.lmgtfygen.domain.entity.ShortenerBody
import com.wilderpereira.lmgtfygen.domain.repository.UrlShortenerApi
import retrofit2.Retrofit
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Wilder on 22/01/17.
 */
class MainPresenter @Inject constructor(val retrofit: Retrofit) : MainContract.Presenter {

    lateinit var view: MainContract.View
    lateinit var context: Context

    var searchUrl = SearchUrl()

    override fun bindView(view: MainContract.View, context: Context) {
        this.view = view
        this.context = context
    }

    override fun onResume() {
        view.displayRateDialogIfNeeded()
    }

    override fun updateSearchType(type: String, url: CharSequence) {
        view.updateGeneratedUrl(searchUrl.updateSearchType(type))
    }

    override fun updateSearchValue(searchValue: String, url: CharSequence) {
        view.updateGeneratedUrl(searchUrl.updateSearchValue(searchValue))
    }

    override fun includeInternetExplainer(include: Boolean) {
        view.updateGeneratedUrl(searchUrl.includeInternetExplainer(include))
    }

    override fun shortenUrl(bigUrl: String) {
        var urlShortener = retrofit.create(UrlShortenerApi::class.java)

        var shortenResponse = urlShortener.shortenUrl(context.getString(R.string.api_key), ShortenerBody(bigUrl.trimEnd().trimStart().replace(' ', '+')))
        shortenResponse.subscribeOn(Schedulers.newThread())
                .doOnSubscribe { view.showLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ shortenResponse ->
                    view.updateGeneratedUrl(shortenResponse.shortUrl.toString())
                    view.displayToast(context.getString(R.string.url_shortened))
                    view.hideLoading()
                },
                        { e ->
                            Log.d("mainpresenter", "error " + e.message)
                            view.displayToast(context.getString(R.string.url_not_shortened))
                            view.hideLoading()
                        })
    }

}

package com.wilderpereira.lmgtfygen.presentation

import android.util.Log
import com.wilderpereira.lmgtfygen.R
import com.wilderpereira.lmgtfygen.domain.entity.SearchUrl
import com.wilderpereira.lmgtfygen.domain.entity.ShortenerBody
import com.wilderpereira.lmgtfygen.domain.repository.UrlShortenerApi
import com.wilderpereira.lmgtfygen.utils.TextProvider
import retrofit2.Retrofit
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Wilder on 22/01/17.
 */
class MainPresenter @Inject constructor(
        val retrofit: Retrofit,
        val textProvider: TextProvider){

    lateinit var view: View

    var searchUrl = SearchUrl()

    fun bindView(view: View) {
        this.view = view
    }

    fun onResume() {
        view.displayRateDialogIfNeeded()
    }

    fun updateSearchType(type: String, url: CharSequence) {
        view.updateGeneratedUrl(searchUrl.updateSearchType(type))
    }

    fun updateSearchValue(searchValue: String, url: CharSequence) {
        view.updateGeneratedUrl(searchUrl.updateSearchValue(searchValue))
    }

    fun includeInternetExplainer(include: Boolean) {
        view.updateGeneratedUrl(searchUrl.includeInternetExplainer(include))
    }

    fun shortenUrl(bigUrl: String) {
        var urlShortener = retrofit.create(UrlShortenerApi::class.java)

        var shortenResponse = urlShortener.shortenUrl(
                textProvider.getText(R.string.api_key),
                ShortenerBody(bigUrl.trimEnd().trimStart().replace(' ', '+')))
        shortenResponse.subscribeOn(Schedulers.newThread())
                .doOnSubscribe { view.showLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ shortenResponse ->
                    view.updateGeneratedUrl(shortenResponse.shortUrl.toString())
                    view.displayToast(textProvider.getText(R.string.url_shortened))
                    view.hideLoading()
                },
                        { e ->
                            Log.d("mainpresenter", "error " + e.message)
                            view.displayToast(textProvider.getText(R.string.url_not_shortened))
                            view.hideLoading()
                        })
    }

    interface View{
        fun updateGeneratedUrl(newString : String)
        fun displayToast(message: String)
        fun displayRateDialogIfNeeded()
        fun showLoading()
        fun hideLoading()
    }
}

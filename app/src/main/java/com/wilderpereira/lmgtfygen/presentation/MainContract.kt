package com.wilderpereira.lmgtfygen.presentation

import android.content.Context

/**
 * Created by Wilder on 24/01/17.
 */
interface MainContract {

    interface View{
        fun updateGeneratedUrl(newString : String)
        fun displayToast(message: String)
        fun displayRateDialogIfNeeded()
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter{
        fun bindView(view : MainContract.View, context: Context)
        fun updateSearchType(type: String, url: CharSequence)
        fun updateSearchValue(searchValue: String, url: CharSequence)
        fun includeInternetExplainer(include: Boolean)
        fun shortenUrl(bigUrl: String)
        fun onResume()
    }

}
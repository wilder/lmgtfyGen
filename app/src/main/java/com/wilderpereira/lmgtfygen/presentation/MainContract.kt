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
    }

    interface Presenter{
        fun bindView(view : MainContract.View, context: Context)
        fun updateSearchType(type: String, url: CharSequence)
        fun updateSearchValue(searchValue: String, url: CharSequence)
        fun shortenUrl(bigUrl: String)
        fun onResume()
    }

}
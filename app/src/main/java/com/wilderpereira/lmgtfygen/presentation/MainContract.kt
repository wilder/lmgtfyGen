package com.wilderpereira.lmgtfygen.presentation

/**
 * Created by Wilder on 24/01/17.
 */
interface MainContract {

    interface View{
        fun updateGeneratedUrl(newString : String)
    }

    interface Presenter{
        fun bindView(view : MainContract.View)
        fun updateSearchType(type: String, url: CharSequence)
        fun updateSearchValue(searchValue: String, url: CharSequence)
        fun shortenUrl(bigUrl: String)
    }

}
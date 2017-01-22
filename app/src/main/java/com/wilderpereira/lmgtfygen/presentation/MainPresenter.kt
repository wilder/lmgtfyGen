package com.wilderpereira.lmgtfygen.presentation

/**
 * Created by Wilder on 22/01/17.
 */
class MainPresenter(val view: MainActivity) {

    fun  updateSearchType(value: String) {

    }

    interface View {
        fun updateGeneratedUrl(newString : String)
    }
}

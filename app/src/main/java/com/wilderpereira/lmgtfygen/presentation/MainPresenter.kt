package com.wilderpereira.lmgtfygen.presentation

/**
 * Created by Wilder on 22/01/17.
 */
class MainPresenter(val view: MainActivity) {

    val TYPE_REGEX = "(?<=t=)\\w*".toRegex()
    val SEARCH_REGEX = "(?<=q=).*$".toRegex()

    fun updateSearchType(type: String, url: CharSequence) {
        view.updateGeneratedUrl(url.replace(TYPE_REGEX, type[0].toLowerCase().toString()))
    }

    fun updateSearchValue(searchValue: String, url: CharSequence){
        view.updateGeneratedUrl(url.replace(SEARCH_REGEX, searchValue))
    }

    interface View {
        fun updateGeneratedUrl(newString : String)
    }
}

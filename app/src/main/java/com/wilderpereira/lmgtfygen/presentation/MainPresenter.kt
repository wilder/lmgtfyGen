package com.wilderpereira.lmgtfygen.presentation

/**
 * Created by Wilder on 22/01/17.
 */
class MainPresenter : MainContract.Presenter  {

    lateinit var view : MainContract.View

    val TYPE_REGEX = "(?<=t=)\\w*".toRegex()
    val SEARCH_REGEX = "(?<=q=).*$".toRegex()

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
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

package com.wilderpereira.lmgtfygen.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URLEncoder

/**
 * Created by Wilder on 22/01/17.
 */

class SearchUrl {

    val TYPE_REGEX = "(?<=t=)\\w*".toRegex()
    val SEARCH_REGEX = "(?<=q=).*$".toRegex()
    val INTERNET_EXPLAINER_REGEX = "(?<=iie=)\\d".toRegex()

    @SerializedName("kind")
    @Expose
    var kind: String? = null
    @SerializedName("id")
    @Expose
    var shortUrl: String? = null
    @SerializedName("longUrl")
    @Expose
    var longUrl: String? = null

    var url: String = "lmgtfy.com/?iie=0&t=&q="

    override fun toString(): String {
        return "SearchUrl(kind=$kind, shortUrl=$shortUrl, longUrl=$longUrl, url='$url')"
    }

    fun updateSearchType(type: String): String {
        url = url.replace(TYPE_REGEX, URLEncoder.encode(type[0].toLowerCase().toString(), "UTF-8"))
        return url
    }

    fun updateSearchValue(searchValue: String): String {
        url = url.replace(SEARCH_REGEX, URLEncoder.encode(searchValue, "UTF-8"))
        return url
    }

    fun includeInternetExplainer(shouldInclude: Boolean) : String{
        url = url.replace(INTERNET_EXPLAINER_REGEX, if(shouldInclude) "1" else "0" )
        return url
    }

}

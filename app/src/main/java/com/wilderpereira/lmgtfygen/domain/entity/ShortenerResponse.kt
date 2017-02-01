package com.wilderpereira.lmgtfygen.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Wilder on 22/01/17.
 */

class ShotenerResponse {
    @SerializedName("kind")
    @Expose
    var kind: String? = null
    @SerializedName("id")
    @Expose
    var shortUrl: String? = null
    @SerializedName("longUrl")
    @Expose
    var longUrl: String? = null

    override fun toString(): String {
        return "ShotenerResponse{" +
                "kind='" + kind + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", longUrl='" + longUrl + '\'' +
                '}'
    }
}

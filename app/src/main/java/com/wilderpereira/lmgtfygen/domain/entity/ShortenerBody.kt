package com.wilderpereira.lmgtfygen.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Wilder on 31/01/17.
 */

class ShortenerBody(@SerializedName("longUrl")
                    @Expose
                    var longUrl: String)

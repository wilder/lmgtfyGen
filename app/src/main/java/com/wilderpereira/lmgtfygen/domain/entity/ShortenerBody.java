package com.wilderpereira.lmgtfygen.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wilder on 31/01/17.
 */

public class ShortenerBody {
    @SerializedName("longUrl")
    @Expose
    String longUrl;

    public ShortenerBody(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {

        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

}

package com.wilderpereira.lmgtfygen.utils

import android.content.res.Resources
import android.support.annotation.StringRes
import javax.inject.Inject

class TextProvider @Inject constructor(val resources: Resources){

    fun getText(@StringRes resId: Int): String = resources.getString(resId)
}
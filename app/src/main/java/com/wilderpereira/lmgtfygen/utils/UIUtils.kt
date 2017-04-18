package com.wilderpereira.lmgtfygen.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * Created by Wilder on 18/04/17.
 */

class UIUtils {
    companion object {
        fun hideKeyboard(context: Context, view: View) {
            val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
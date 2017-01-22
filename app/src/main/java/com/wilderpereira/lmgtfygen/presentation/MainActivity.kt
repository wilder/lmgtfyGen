package com.wilderpereira.lmgtfygen.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.jakewharton.rxbinding.widget.RxAdapterView
import com.wilderpereira.lmgtfygen.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadSpinner()
    }

    private fun loadSpinner(){
        val adapter = ArrayAdapter.createFromResource(
                this, R.array.search_types, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        searchTypeSpinner.adapter = adapter
    }

}
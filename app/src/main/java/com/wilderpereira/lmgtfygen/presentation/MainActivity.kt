package com.wilderpereira.lmgtfygen.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import com.jakewharton.rxbinding.widget.RxAdapterView
import com.jakewharton.rxbinding.widget.RxTextView
import com.wilderpereira.lmgtfygen.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainPresenter = MainPresenter(this)
        loadSpinner()

        val spinnerSub = RxAdapterView.itemSelections(searchTypeSpinner)
                .subscribe { pos -> presenter.updateSearchType(searchTypeSpinner.selectedItem.toString(), generatedUrlTv.text) }

        val editTextSub = RxTextView.textChanges(searchEt)
                .subscribe { text -> presenter.updateSearchValue(text.toString(), generatedUrlTv.text)}

    }

    private fun loadSpinner(){
        val adapter = ArrayAdapter.createFromResource(
                this, R.array.search_types, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        searchTypeSpinner.adapter = adapter
    }

    override fun updateGeneratedUrl(newString: String) {
        generatedUrlTv.text = newString
    }

}
package com.wilderpereira.lmgtfygen.presentation

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import com.jakewharton.rxbinding.widget.RxAdapterView
import com.jakewharton.rxbinding.widget.RxTextView
import com.wilderpereira.lmgtfygen.R
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ClipData
import android.support.v4.app.ShareCompat
import android.widget.EditText
import android.widget.Toast
import com.wilderpereira.lmgtfygen.App
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject lateinit var presenter: MainContract.Presenter
    lateinit var urlEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getComponent().inject(this)
        presenter.bindView(this)

        urlEditText = findViewById(R.id.searchEt) as EditText

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

    fun copyToClipboard(v: View){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("url", generatedUrlTv.text)
        clipboard.primaryClip = clip
        Toast.makeText(this, "Url copied to clipboard", Toast.LENGTH_SHORT).show()
    }

    fun shareUrl(v: View){
        ShareCompat.IntentBuilder
                .from(this)
                .setText(generatedUrlTv.text)
                .setType("text/plain")
                .startChooser()
    }

    fun shortenUrl(v: View){
        presenter.shortenUrl(urlEditText.text.toString())
        Toast.makeText(this, "Url shortened", Toast.LENGTH_SHORT).show()
    }

}
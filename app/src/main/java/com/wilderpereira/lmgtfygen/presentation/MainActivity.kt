package com.wilderpereira.lmgtfygen.presentation

import android.app.ProgressDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxAdapterView
import com.jakewharton.rxbinding.widget.RxCompoundButton
import com.jakewharton.rxbinding.widget.RxTextView
import com.kobakei.ratethisapp.RateThisApp
import com.wilderpereira.lmgtfygen.App
import com.wilderpereira.lmgtfygen.R
import com.wilderpereira.lmgtfygen.extensions.hideKeyboard
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.indeterminateProgressDialog
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainPresenter.View {

    @Inject lateinit var presenter: MainPresenter
    private val mLoadingDialog: ProgressDialog by lazy { indeterminateProgressDialog("Shortening url...", "Please wait").apply { setCancelable(false) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun displayRateDialogIfNeeded() {
        RateThisApp.showRateDialogIfNeeded(this@MainActivity)
    }

    override fun updateGeneratedUrl(newString: String) {
        generatedUrlTv.text = newString
    }

    override fun displayToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        mLoadingDialog.show()
    }

    override fun hideLoading() {
        mLoadingDialog.dismiss()
    }

    fun copyToClipboard(v: View) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("url", generatedUrlTv.text)
        clipboard.primaryClip = clip
        displayToast(getString(R.string.url_copied))
    }

    fun shareUrl(v: View) {
        ShareCompat.IntentBuilder
                .from(this)
                .setText(generatedUrlTv.text)
                .setType("text/plain")
                .startChooser()
    }

    fun shortenUrl(v: View) {
        presenter.shortenUrl(generatedUrlTv.text.toString())
    }

    private fun init() {
        (application as App).component.inject(this)
        presenter.bindView(this, this.baseContext)

        val config = RateThisApp.Config(3, 5)
        RateThisApp.init(config)
        RateThisApp.onCreate(this@MainActivity)

        loadSpinner()

        setListeners()
    }

    private fun loadSpinner() {
        val adapter = ArrayAdapter.createFromResource(
                this, R.array.search_types, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        searchTypeSpinner.adapter = adapter
    }

    private fun setListeners() {
        RxAdapterView.itemSelections(searchTypeSpinner)
                .subscribe { pos -> presenter.updateSearchType(searchTypeSpinner.selectedItem.toString(), generatedUrlTv.text) }

        RxTextView.textChanges(searchEt)
                .subscribe { text -> presenter.updateSearchValue(text.toString(), generatedUrlTv.text) }

        RxCompoundButton.checkedChanges(internetExplainerCb).subscribe { checked -> presenter.includeInternetExplainer(checked) }

        RxView.focusChanges(searchEt).subscribe { hasFocus -> if (!hasFocus) searchEt.hideKeyboard() }
    }

}
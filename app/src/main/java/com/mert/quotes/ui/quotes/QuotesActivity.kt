package com.mert.quotes.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mert.quotes.R
import com.mert.quotes.data.Quote
import com.mert.quotes.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    private lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initUI()
        setObservers()
    }

    private fun initUI() {
        // Create factory
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // Connect to the viewModel right here by Viewmodelprovider
        // ViewModelProvider waits a view and a factory to initialize a viewmodel.
        viewModel = ViewModelProvider(this, factory)
            .get(QuotesViewModel::class.java)

    }

    private fun setObservers() {
        // When quote list is changed, update the screen
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val str = StringBuilder()
            quotes.forEach{
                println(it)
                str.append("$it\n\n")
            }
            textView_quotes.text = str.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }

    }
}
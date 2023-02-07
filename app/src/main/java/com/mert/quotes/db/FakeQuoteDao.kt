package com.mert.quotes.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mert.quotes.data.Quote

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    // Mutable live data for quotes
    private val quotes = MutableLiveData<List<Quote>>()
    init {
        quotes.value = quoteList
    }
    // Function for adding quotes to the database
    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList // triggers the observers
    }
    // Function for getting quotes
    fun getQuotes() = quotes as LiveData<List<Quote>> // cast read-only for outside classes
}
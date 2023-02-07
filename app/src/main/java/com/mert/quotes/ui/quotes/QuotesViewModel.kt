package com.mert.quotes.ui.quotes

import androidx.lifecycle.ViewModel
import com.mert.quotes.data.Quote
import com.mert.quotes.di.QuoteRepository

// ViewModel connects to the repository.
class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() =  quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}
package com.mert.quotes.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mert.quotes.di.QuoteRepository

// You need a factory to make sure view models are not destroyed
@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory (private val quoteRepository: QuoteRepository):
    ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}
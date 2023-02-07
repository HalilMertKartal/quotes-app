package com.mert.quotes.utils

import com.mert.quotes.db.FakeDatabase
import com.mert.quotes.di.QuoteRepository
import com.mert.quotes.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}
package com.mert.quotes.data

class Quote (
    private val quoteText: String,
    private val author: String
        ) {
    override fun toString(): String {
        return "$author - $quoteText"
    }
}
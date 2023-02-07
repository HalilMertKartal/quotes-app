package com.mert.quotes.db

// Private primary constructor inaccessible from other classes
class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        // The only way to get hold of the FakeDatabase object
        fun getInstance() =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}
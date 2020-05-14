package com.douglasborba.booksofny.data.repository

import com.douglasborba.booksofny.data.BooksResult

interface BooksRepository {
    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
}
package com.douglasborba.booksofny.data.repository

interface BooksRepository {
    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
}
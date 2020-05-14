package com.douglasborba.booksofny.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.douglasborba.booksofny.data.model.Book

class BooksViewModel : ViewModel() {

    // a view reage a alterações do live data
    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createFakeBooks()
    }

    fun createFakeBooks(): List<Book> {
        return listOf<Book>(
            Book("Title 1", "Author 1"),
            Book("Title 2", "Author2 "),
            Book("Title 3", "Author 3")
        )
    }
}
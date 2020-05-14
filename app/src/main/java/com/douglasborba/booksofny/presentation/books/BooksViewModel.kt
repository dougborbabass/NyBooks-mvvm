package com.douglasborba.booksofny.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.douglasborba.booksofny.data.ApiService
import com.douglasborba.booksofny.data.model.Book
import com.douglasborba.booksofny.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    // a view reage a alterações do live data
    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.bookResults) {
                            val mBook = Book(
                                title = result.bookDetails[0].title,
                                author = result.bookDetails[0].author
                            )
                            books.add(mBook)
                        }
                    }
                    booksLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }
        })
    }
}
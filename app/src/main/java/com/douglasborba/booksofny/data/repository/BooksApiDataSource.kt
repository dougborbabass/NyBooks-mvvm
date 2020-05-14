package com.douglasborba.booksofny.data.repository

import com.douglasborba.booksofny.R
import com.douglasborba.booksofny.data.ApiService
import com.douglasborba.booksofny.data.BooksResult
import com.douglasborba.booksofny.data.model.Book
import com.douglasborba.booksofny.data.response.BookBodyResponse
import com.douglasborba.booksofny.presentation.books.BooksViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksApiDataSource : BooksRepository {

    // função que recebe outra função por parametro
    override fun getBooks(booksResultCallback: (result: BooksResult) -> Unit) {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.bookResults) {
                                val mBook = result.bookDetailsResponse[0].getBookModel()
                                books.add(mBook)
                            }
                        }
                        // a callback faz o papel do liveData
                        booksResultCallback(BooksResult.Success(books))
                    }
                    else -> booksResultCallback(BooksResult.ApiError(response.code()))
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                booksResultCallback(BooksResult.ServerError)
            }
        })
    }
}
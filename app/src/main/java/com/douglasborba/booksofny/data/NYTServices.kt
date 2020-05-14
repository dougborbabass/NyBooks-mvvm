package com.douglasborba.booksofny.data

import com.douglasborba.booksofny.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {
    // Endpoint da API
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "7TAUVO2soup2tjB3GCJOeCn6bKwWMmNV",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}
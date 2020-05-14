package com.douglasborba.booksofny.data

import com.douglasborba.booksofny.data.model.Book
import retrofit2.Call
import retrofit2.http.GET




interface NYTServices {
    // Endpoint da API
    @GET("lists.json")
    fun listRepos(): Call<List<>>
}
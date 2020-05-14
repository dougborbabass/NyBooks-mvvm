package com.douglasborba.booksofny.data.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


// criando um singleton para instanciar apenas uma vez o retrofit para toda aplicação
object ApiService {
    private fun initRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    // instancia do retrofit criada e associada com a classe de serviço (endpoints)
    val service: NYTServices = initRetrofit()
        .create(NYTServices::class.java)
}
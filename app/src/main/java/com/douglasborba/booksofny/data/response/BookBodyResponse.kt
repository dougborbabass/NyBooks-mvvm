package com.douglasborba.booksofny.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// plugin do kapt é responsável por esta notação em tempo de execução
@JsonClass(generateAdapter = true)
data class BookBodyResponse(
    @Json(name = "results")
    val bookResults: List<BookResultsResponse>
)
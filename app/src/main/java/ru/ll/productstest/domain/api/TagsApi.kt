package ru.ll.productstest.domain.api

import retrofit2.http.GET

interface TagsApi {

    @GET("getAllTags")
    suspend fun getAllTags(): List<NwTag>
}
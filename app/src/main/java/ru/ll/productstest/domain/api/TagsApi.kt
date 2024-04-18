package ru.ll.productstest.domain.api

import retrofit2.http.POST

interface TagsApi {

    @POST("getAllTags")
    suspend fun getAllTags(): NwTags
}
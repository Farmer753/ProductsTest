package ru.ll.productstest.domain.api

import retrofit2.http.POST

interface CategoriesApi {

    @POST("getAllCategories")
    suspend fun getAllCategories(): NwCategories
}
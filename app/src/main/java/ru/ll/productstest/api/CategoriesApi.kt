package ru.ll.productstest.api

import retrofit2.http.POST

interface CategoriesApi {

    @POST("getAllCategories")
    suspend fun getAllCategories(): NwCategories
}
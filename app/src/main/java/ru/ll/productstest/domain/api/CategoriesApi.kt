package ru.ll.productstest.domain.api

import retrofit2.http.GET

interface CategoriesApi {

    @GET("getAllCategories")
    suspend fun getAllCategories(): List<NwCategory>
}
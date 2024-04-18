package ru.ll.productstest.domain.api

import retrofit2.http.POST

interface ProductsApi {

    @POST("getAllProducts")
    suspend fun getAllProducts(): NwProducts
}
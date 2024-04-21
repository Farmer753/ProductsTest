package ru.ll.productstest.domain.api

import retrofit2.http.GET

interface ProductsApi {

    @GET("getAllProducts")
    suspend fun getAllProducts(): List<NwProduct>
}
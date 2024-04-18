package ru.ll.productstest.domain.api

data class NwProducts(
    val id: Int,
    val categoryId: Int,
    val name: String,
    val description: String,
    val image: String,
    val priceCurrent: Int,
    val priceOld: Int?,
    val measure: Int,
    val measureUnit: String,
    val energyPer100grams: Double,
    val proteinsPer100grams: Double,
    val fatsPer100grams: Double,
    val carbohydratesPer100grams: Double,
    val tagIds: NwTags
)

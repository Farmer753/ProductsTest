package ru.ll.productstest.domain.api

import com.squareup.moshi.Json

data class NwProduct(
    val id: Int,
    @Json(name = "category_id")
    val categoryId: Int,
    val name: String,
    val description: String,
    val image: String,
    @Json(name = "price_current")
    val priceCurrent: Int,
    @Json(name = "price_old")
    val priceOld: Int?,
    val measure: Int,
    @Json(name = "measure_unit")
    val measureUnit: String,
    @Json(name = "energy_per_100_grams")
    val energyPer100grams: Double,
    @Json(name = "proteins_per_100_grams")
    val proteinsPer100grams: Double,
    @Json(name = "fats_per_100_grams")
    val fatsPer100grams: Double,
    @Json(name = "carbohydrates_per_100_grams")
    val carbohydratesPer100grams: Double,
    @Json(name = "tag_ids")
    val tagIds: List<Int>
)

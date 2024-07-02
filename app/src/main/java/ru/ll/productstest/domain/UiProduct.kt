package ru.ll.productstest.domain

import kotlinx.serialization.Serializable
import ru.ll.productstest.domain.UiProduct.Companion.TOM
import kotlin.random.Random

@Serializable
data class UiProduct(
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
    val tagIds: List<Int>
) {
    companion object {
        const val TOM =
            "https://s3-alpha-sig.figma.com/img/073e/0a2a/fc2758da57ec1cfd3b55fb79d81c9c7c?Expires=1721001600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=SpVLgh6sM5suArBJfK8rhX0xVHzP9UtI~DYzMhnY3jTJ8nmboocPqtsErLBfc1tJoph417Fq~FIKt3IjZF62yZm23qdnwDcUGgxE30E63YSwpuvshnD5fMaf0SWaSzbS3l0Bdx3vypuLh7-M4lwQxHZb9ux7FodG~sFLd6K3It8kpW~ZEFsleD8L9jSK4g4aPMpqD6c2zSLkNDbksOuzodTtWg5B7TYY5iQDYuK2ZYdG1hTBWy5hMk3uzvWuL4udXMmcjeC3diLHWgGOklW3iSntkHpckdE2PAa43AZfalruMo871l6Kf0HzN18EjxcH2U4AANst5slEUjOfjjchtw__"
    }
}

fun test(): UiProduct {
    return UiProduct(
        id = Random.nextInt(),
        categoryId = Random.nextInt(),
        name = "Название блюда ${Random.nextInt()}",
        description = "description ${Random.nextInt()}",
        image = TOM,
        priceCurrent = Random.nextInt(999),
        priceOld = if (Random.nextBoolean()) Random.nextInt(999) else null,
        measure = Random.nextInt(),
        measureUnit = "г",
        energyPer100grams = Random.nextDouble(),
        proteinsPer100grams = Random.nextDouble(),
        fatsPer100grams = Random.nextDouble(),
        carbohydratesPer100grams = Random.nextDouble(),
        tagIds = listOf(1)
    )
}

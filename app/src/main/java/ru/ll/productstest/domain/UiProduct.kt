package ru.ll.productstest.domain

import ru.ll.productstest.domain.UiProduct.Companion.TOM
import kotlin.random.Random

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
            "https://s3-alpha-sig.figma.com/img/6861/f5d0/b3bbfc363f115fdeba2e726f1f1a6c29?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=h0cWSi8ycU3~HjxuiHU3JWL531Xu~rJiCJW1Asrz1sWhsQ4ihMxjdcLg-OJEie8cOkaSeJI2nMwLixoIuootT8v7Va-iiL8znv~MIT4MBoZI5zm7gVV8ha4ZUmpAsdGH-NcIkte0L8K2m1bsnEE8ApjZUfXojXWaTJ-cpP9nSH2mURbH9LTM0Rou4M1MkaxHOJCNDMCCU5XCMZ6i-Rc0YrZxpYJ~qhMbL7EHw-j7EEOyJGSK1u8UMr7Cyv94eQccfLrwg1~J8YMgebFyVMSM7mL6-l~8ygsg5znibQoKOYpyD1LWV3QtHgEgbCNOxyaIDd176K62aVbgtrNjmNqHXA__"
    }
}

fun test(): UiProduct {
    return UiProduct(
        id = Random.nextInt(),
        categoryId = Random.nextInt(),
        name = "Название блюда ${Random.nextInt()}",
        description = "description ${Random.nextInt()}",
        image = TOM,
        priceCurrent = Random.nextInt(),
        priceOld = if (Random.nextBoolean()) Random.nextInt() else null,
        measure = Random.nextInt(),
        measureUnit = "г",
        energyPer100grams = Random.nextDouble(),
        proteinsPer100grams = Random.nextDouble(),
        fatsPer100grams = Random.nextDouble(),
        carbohydratesPer100grams = Random.nextDouble(),
        tagIds = listOf(1)
    )
}

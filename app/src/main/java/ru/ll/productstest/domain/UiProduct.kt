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
            "https://s3-alpha-sig.figma.com/img/6861/f5d0/b3bbfc363f115fdeba2e726f1f1a6c29?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=RlN19IwLYucTqPZ9RGgaIO5OZKMHiZoz9jqaBg7Gexp0DU~o3XA1dUx3-nn9t3QFUqjZMjXvkR1SRtNDZV-oRynBoG2ty4h9Y~qiC-15SU2im-zSG-6E9~YvLjhw~WNSXE0-pP9BHFmkEXqhLl8eSRQo9DrZlng-1ze0hjll79htaF6kKxDzyv6yNlWAEiqjcIL7CZQ6W4m1iq4~S~wRzda6odMpWdSSRVHkGeNxBMsCUpa9hALkPLIAWHSu8~qaOhfX8AcsCNFlrXM1xVErdVYerIEax1kHCKwOqqBmB0xb6gP8aJL0pq6lL8gmMJINfeBesU4i20-XAAN8BumXBA__"
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

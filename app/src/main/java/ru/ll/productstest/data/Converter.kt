package ru.ll.productstest.data

import ru.ll.productstest.domain.UiCategory
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.domain.UiTag
import ru.ll.productstest.domain.api.NwCategory
import ru.ll.productstest.domain.api.NwProduct
import ru.ll.productstest.domain.api.NwTag

class Converter {
    fun convert(nwProduct: NwProduct): UiProduct {
        return UiProduct(
            id = nwProduct.id,
            categoryId = nwProduct.categoryId,
            name = nwProduct.name,
            description = nwProduct.description,
            image = nwProduct.image,
            priceCurrent = nwProduct.priceCurrent,
            priceOld = nwProduct.priceOld,
            measure = nwProduct.measure,
            measureUnit = nwProduct.measureUnit,
            energyPer100grams = nwProduct.energyPer100grams,
            proteinsPer100grams = nwProduct.proteinsPer100grams,
            fatsPer100grams = nwProduct.fatsPer100grams,
            carbohydratesPer100grams = nwProduct.carbohydratesPer100grams,
            tagIds = nwProduct.tagIds
        )
    }

    fun convert(nwTag: NwTag): UiTag {
        return UiTag(
            id = nwTag.id,
            name = nwTag.name
        )
    }

    fun convert(nwCategory: NwCategory): UiCategory {
        return UiCategory(
            id = nwCategory.id,
            name = nwCategory.name
        )
    }
}
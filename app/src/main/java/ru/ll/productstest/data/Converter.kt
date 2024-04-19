package ru.ll.productstest.data

import ru.ll.productstest.domain.UiCategories
import ru.ll.productstest.domain.UiProducts
import ru.ll.productstest.domain.UiTags
import ru.ll.productstest.domain.api.NwCategories
import ru.ll.productstest.domain.api.NwProducts
import ru.ll.productstest.domain.api.NwTags

class Converter {
    fun convert(nwProducts: NwProducts): UiProducts {
        return UiProducts(
            id = nwProducts.id,
            categoryId = nwProducts.categoryId,
            name = nwProducts.name,
            description = nwProducts.description,
            image = nwProducts.image,
            priceCurrent = nwProducts.priceCurrent,
            priceOld = nwProducts.priceOld,
            measure = nwProducts.measure,
            measureUnit = nwProducts.measureUnit,
            energyPer100grams = nwProducts.energyPer100grams,
            proteinsPer100grams = nwProducts.proteinsPer100grams,
            fatsPer100grams = nwProducts.fatsPer100grams,
            carbohydratesPer100grams = nwProducts.carbohydratesPer100grams,
            tagId = nwProducts.tagIds.id,
            tagName = nwProducts.tagIds.name
        )
    }

    fun convert(nwTags: NwTags): UiTags {
        return UiTags(
            id = nwTags.id,
            name = nwTags.name
        )
    }

    fun convert(nwCategories: NwCategories): UiCategories {
        return UiCategories(
            id = nwCategories.id,
            name = nwCategories.name
        )
    }
}
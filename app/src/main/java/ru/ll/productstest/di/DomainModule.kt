package ru.ll.productstest.di

import org.koin.dsl.module
import ru.ll.productstest.data.CategoriesRepositoryImpl
import ru.ll.productstest.data.Converter
import ru.ll.productstest.data.ProductsRepositoryImpl
import ru.ll.productstest.data.TagsRepositoryImpl
import ru.ll.productstest.domain.CategoriesRepository
import ru.ll.productstest.domain.ProductsRepository
import ru.ll.productstest.domain.TagsRepository

fun domainModule() = module {
    single { Converter() }
    single<ProductsRepository> { ProductsRepositoryImpl(get(), get()) }
    single<CategoriesRepository> { CategoriesRepositoryImpl(get(), get()) }
    single<TagsRepository> { TagsRepositoryImpl(get(), get()) }
}
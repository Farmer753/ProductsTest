package ru.ll.productstest.di

import org.koin.dsl.module
import ru.ll.productstest.data.Converter

fun domainModule() = module {

    single { Converter() }

}
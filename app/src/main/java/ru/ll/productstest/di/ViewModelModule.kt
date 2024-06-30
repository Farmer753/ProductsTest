package ru.ll.productstest.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ll.productstest.ui.BasketViewModel
import ru.ll.productstest.ui.catalog.SubCatalogViewModel
import ru.ll.productstest.ui.product.ProductViewModel

fun viewModelModule() = module {
    viewModel { ProductViewModel() }
    viewModel { BasketViewModel() }
    viewModel { SubCatalogViewModel(get(), get(), get()) }
}
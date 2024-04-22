package ru.ll.productstest.di

import android.content.Context
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

fun applicationModule(context: Context) = module {

    single { context }
    single { Dispatchers.IO }
}
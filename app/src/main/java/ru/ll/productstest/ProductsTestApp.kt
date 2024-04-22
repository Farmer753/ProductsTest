package ru.ll.productstest

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin
import ru.ll.productstest.di.applicationModule
import ru.ll.productstest.di.domainModule
import ru.ll.productstest.di.networkModule
import ru.ll.productstest.di.viewModelModule
import timber.log.Timber

class ProductsTestApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("Timber init")
        // start Koin!
        startKoin {
            // declare modules
            modules(
                applicationModule(this@ProductsTestApp),
                networkModule(),
                domainModule(),
                viewModelModule()
            )
        }
    }
}

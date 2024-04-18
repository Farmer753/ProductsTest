package ru.ll.productstest

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin
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
//                applicationModule(this@ProductsTestApp),
//                networkModule(),
//                storageModule(),
//                domainModule(),
//                viewModelModule()
            )
        }
    }
}

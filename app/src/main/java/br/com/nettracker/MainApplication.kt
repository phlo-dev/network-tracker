@file:Suppress("unused")

package br.com.nettracker

import android.app.Application
import br.com.nettracker.di.moduleList
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(moduleList)
        }
    }
}
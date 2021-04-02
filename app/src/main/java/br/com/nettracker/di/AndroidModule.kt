package br.com.nettracker.di

import br.com.nettracker.ui.notification.manager.NotificationManager
import br.com.nettracker.ui.notification.manager.NotificationManagerImpl
import br.com.nettracker.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {

    factory<NotificationManager> {
        NotificationManagerImpl(androidContext())
    }

    viewModel {
        MainViewModel(mainRepository = get())
    }
}
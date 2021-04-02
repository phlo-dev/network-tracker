package br.com.nettracker.di

import br.com.nettracker.repository.MainRepository
import br.com.nettracker.repository.MainRepositoryImpl
import br.com.nettracker.repository.workmanager.ConnectionWorkerProviderImpl
import br.com.nettracker.repository.workmanager.WorkerProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    factory<MainRepository> { MainRepositoryImpl() }

    factory<WorkerProvider> {
        ConnectionWorkerProviderImpl(androidContext())
    }
}
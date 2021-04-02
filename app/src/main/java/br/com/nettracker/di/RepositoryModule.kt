package br.com.nettracker.di

import br.com.nettracker.repository.MainRepository
import br.com.nettracker.repository.MainRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<MainRepository> { MainRepositoryImpl() }

}
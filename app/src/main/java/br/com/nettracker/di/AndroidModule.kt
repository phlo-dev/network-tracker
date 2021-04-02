package br.com.nettracker.di

import br.com.nettracker.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {

    viewModel {
        MainViewModel(mainRepository = get())
    }
}
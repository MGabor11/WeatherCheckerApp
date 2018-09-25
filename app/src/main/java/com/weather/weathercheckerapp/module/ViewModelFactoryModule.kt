package com.weather.weathercheckerapp.module

import androidx.lifecycle.ViewModelProvider
import com.weather.weathercheckerapp.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

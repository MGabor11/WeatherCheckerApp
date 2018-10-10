package com.weather.weathercheckerapp.module

import androidx.lifecycle.ViewModel
import com.weather.weathercheckerapp.annotation.ViewModelKey
import com.weather.weathercheckerapp.viewmodel.CitySelectorViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CitySelectorViewModel::class)
    abstract fun bindCitySelectorViewModel(citySelectorViewModel: CitySelectorViewModel): ViewModel
}

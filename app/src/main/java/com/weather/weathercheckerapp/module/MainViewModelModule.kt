package com.weather.weathercheckerapp.module

import androidx.lifecycle.ViewModel
import com.weather.weathercheckerapp.annotation.ViewModelKey
import com.weather.weathercheckerapp.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(myViewModel: MainViewModel): ViewModel

}
package com.weather.weathercheckerapp.module

import com.weather.weathercheckerapp.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(): MainViewModel {
        return MainViewModel()
    }

}

package com.weather.weathercheckerapp.component

import com.weather.weathercheckerapp.MainActivity
import com.weather.weathercheckerapp.module.MainViewModelModule
import com.weather.weathercheckerapp.module.ViewModelFactoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelFactoryModule::class, MainViewModelModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
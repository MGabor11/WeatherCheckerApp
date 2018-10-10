package com.weather.weathercheckerapp.component

import com.weather.weathercheckerapp.WeatherApplication
import com.weather.weathercheckerapp.module.ActivityBuilderModule
import com.weather.weathercheckerapp.module.ViewModelFactoryModule
import com.weather.weathercheckerapp.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class, AndroidSupportInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<WeatherApplication> {

    override fun inject(application: WeatherApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: WeatherApplication): Builder

        fun build(): AppComponent
    }
}

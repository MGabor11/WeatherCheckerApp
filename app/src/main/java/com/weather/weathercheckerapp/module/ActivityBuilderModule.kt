package com.weather.weathercheckerapp.module

import com.weather.weathercheckerapp.MainActivity
import com.weather.weathercheckerapp.fragment.CitySelectorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector()
    internal abstract fun bindCitySelectorFragment(): CitySelectorFragment

}

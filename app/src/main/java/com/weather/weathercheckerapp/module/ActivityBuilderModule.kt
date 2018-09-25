package com.weather.weathercheckerapp.module

import com.weather.weathercheckerapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity

}

package com.weather.weathercheckerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.weather.weathercheckerapp.component.AppComponent
import com.weather.weathercheckerapp.component.DaggerAppComponent
import com.weather.weathercheckerapp.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDI()

        appComponent.inject(this)

        ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

    }

    private fun initDI() {
        appComponent = DaggerAppComponent.builder()
                .build()
    }

}

package com.weather.weathercheckerapp

import android.os.Bundle
import android.view.Window
import androidx.lifecycle.ViewModelProviders
import com.weather.weathercheckerapp.viewmodel.MainViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val vm = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

    }

}

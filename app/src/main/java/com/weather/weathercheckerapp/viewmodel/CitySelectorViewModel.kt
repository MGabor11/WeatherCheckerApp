package com.weather.weathercheckerapp.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CitySelectorViewModel @Inject constructor() : ViewModel() {

    var queryCity : String? = null

}
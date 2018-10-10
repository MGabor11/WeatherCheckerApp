package com.weather.weathercheckerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CitySelectorViewModel @Inject constructor() : ViewModel() {

    var queryCity: MutableLiveData<String> = MutableLiveData()
}

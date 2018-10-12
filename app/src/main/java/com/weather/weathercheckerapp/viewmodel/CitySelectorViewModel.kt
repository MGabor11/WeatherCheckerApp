package com.weather.weathercheckerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.places.Place
import javax.inject.Inject

class CitySelectorViewModel @Inject constructor() : ViewModel() {

    var queryCity: MutableLiveData<Place> = MutableLiveData()
}

package com.weather.weathercheckerapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.weather.weathercheckerapp.R

class CitySelectorFragment : Fragment(){

    val autocompleteFragment = fragmentManager?.findFragmentById(R.id.place_autocomplete_fragment) as PlaceAutocompleteFragment?

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_city_selector, container, false)

    }

}

package com.weather.weathercheckerapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment
import com.weather.weathercheckerapp.R
import com.weather.weathercheckerapp.ViewModelFactory
import com.weather.weathercheckerapp.viewmodel.CitySelectorViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class CitySelectorFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CitySelectorViewModel

    private lateinit var placeAutocompleteFragment: SupportPlaceAutocompleteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CitySelectorViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_city_selector, container, false).also {
            placeAutocompleteFragment = childFragmentManager.findFragmentById(R.id.place_autocomplete_fragment) as SupportPlaceAutocompleteFragment
            initAutoCompleteInputStyle(it)
            setCityTypeFilter()
            setOnPlaceChangedListener()
        }
    }

    private fun initAutoCompleteInputStyle(view: View) {
        view.findViewById<ImageView>(R.id.place_autocomplete_search_button).apply {
            setImageDrawable(resources.getDrawable(R.drawable.ic_search, null))
        }

        view.findViewById<ImageView>(R.id.place_autocomplete_clear_button).apply {
            setImageDrawable(resources.getDrawable(R.drawable.ic_clear, null))
        }

        view.findViewById<EditText>(R.id.place_autocomplete_search_input).apply {
            setTextColor(ContextCompat.getColor(context, R.color.primaryTextColor))
            setHintTextColor(ContextCompat.getColor(context, R.color.primaryTextColor))
        }
    }

    private fun setCityTypeFilter() {
        val typeFilter = AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
                .build()
        placeAutocompleteFragment.setFilter(typeFilter)
    }

    private fun setOnPlaceChangedListener() {
        placeAutocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                viewModel.queryCity.value = place
            }

            override fun onError(status: Status) {
                // not implemented
            }
        })
    }
}

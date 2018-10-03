package com.weather.weathercheckerapp.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.weather.weathercheckerapp.R
import com.weather.weathercheckerapp.ViewModelFactory
import com.weather.weathercheckerapp.viewmodel.CitySelectorViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class CitySelectorFragment : DaggerFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var queryCity : String

    lateinit var viewModel: CitySelectorViewModel

    lateinit var placeAutocompleteInput : EditText

    lateinit var searchIcon : ImageView

    lateinit var clearIcon : ImageView

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CitySelectorViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_city_selector, container, false)
        initAutoCompleteInputStyle(view)
        return view
    }

    private fun initAutoCompleteInputStyle(view: View) {
        placeAutocompleteInput = view.findViewById(R.id.place_autocomplete_search_input)
        searchIcon = view.findViewById(R.id.place_autocomplete_search_button)
        searchIcon.setImageDrawable(resources.getDrawable(R.drawable.ic_search))
        clearIcon = view.findViewById(R.id.place_autocomplete_clear_button)
        clearIcon.setImageDrawable(resources.getDrawable(R.drawable.ic_clear))
        placeAutocompleteInput.setTextColor(resources.getColor(R.color.primaryTextColor))
        placeAutocompleteInput.setHintTextColor(resources.getColor(R.color.primaryTextColor))
        placeAutocompleteInput.onChange { onCitySelected() }
    }

    private fun onCitySelected() {
        queryCity = placeAutocompleteInput.getText().toString()
    }

    private fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

}

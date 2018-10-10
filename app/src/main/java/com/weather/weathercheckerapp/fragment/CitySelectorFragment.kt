package com.weather.weathercheckerapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import com.weather.weathercheckerapp.R
import com.weather.weathercheckerapp.ViewModelFactory
import com.weather.weathercheckerapp.util.onChange
import com.weather.weathercheckerapp.viewmodel.CitySelectorViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CitySelectorFragment : DaggerFragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: CitySelectorViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CitySelectorViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city_selector, container, false)
        initAutoCompleteInput(view)
        return view
    }

    private fun initAutoCompleteInput(view: View) {
        view.findViewById<ImageView>(R.id.place_autocomplete_search_button).apply {
            setImageDrawable(resources.getDrawable(R.drawable.ic_search, null))
        }

        view.findViewById<ImageView>(R.id.place_autocomplete_clear_button).apply {
            setImageDrawable(resources.getDrawable(R.drawable.ic_clear, null))
        }

        view.findViewById<EditText>(R.id.place_autocomplete_search_input).apply {
            setTextColor(resources.getColor(R.color.primaryTextColor))
            setHintTextColor(resources.getColor(R.color.primaryTextColor))
            onChange { viewModel.queryCity = text.toString() }
        }
    }
}

package com.weather.weathercheckerapp.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

inline fun EditText.onChange(crossinline getChangedText: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            getChangedText(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // not implemented
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // not implemented
        }
    })
}

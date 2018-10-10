package com.weather.weathercheckerapp.fragment

import android.widget.EditText
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.weather.weathercheckerapp.MainActivity
import com.weather.weathercheckerapp.R
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CitySelectorFragmentTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    private lateinit var device: UiDevice

    private var city: String = "Budapest"

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    }

    @Test
    fun testFragmentViewVisibility() {
        onView(withId(R.id.place_autocomplete_fragment)).check(matches((isDisplayed())))
        onView(withId(R.id.place_autocomplete_search_button)).check(matches((isDisplayed())))
        onView(withId(R.id.place_autocomplete_clear_button)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testSearchCity() {
        onView(withId(R.id.place_autocomplete_search_button)).perform(click())
        Thread.sleep(700)
        val input = device.findObject(UiSelector().instance(0).className(EditText::class.java))
        input.text = city
        Thread.sleep(700)
        val firstResult = device.findObjects(By.text(city)).get(1)
        firstResult.click()
        Thread.sleep(700)
        onView(withId(R.id.place_autocomplete_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.place_autocomplete_search_input)).check(matches(withText(city)))
        onView(withId(R.id.place_autocomplete_clear_button)).check(matches((isDisplayed())))
        onView(withId(R.id.place_autocomplete_clear_button)).perform(click())
        onView(withId(R.id.place_autocomplete_clear_button)).check(matches(not(isDisplayed())))
    }

}

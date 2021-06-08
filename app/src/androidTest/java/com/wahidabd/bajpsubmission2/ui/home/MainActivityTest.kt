package com.wahidabd.bajpsubmission2.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.wahidabd.bajpsubmission2.R
import com.wahidabd.bajpsubmission2.utils.Helper
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java, true)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(Helper.espressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(Helper.espressoIdlingResource())
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
        }
    }

    @Test
    fun movieDetail() {
        onView(withId(R.id.appBarLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.toolBar)).check(matches(isDisplayed()))
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).apply {
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            Espresso.pressBack()
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(19, click()))
            Espresso.pressBack()
        }
    }

    @Test
    fun loadTv() {
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
        onView(withId(R.id.bottom_nav)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
        }
    }

    @Test
    fun tvDetail() {
        onView(withId(R.id.appBarLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.toolBar)).check(matches(isDisplayed()))
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
        onView(withId(R.id.bottom_nav)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            Espresso.pressBack()
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(19, click()))
            Espresso.pressBack()
        }
    }
}
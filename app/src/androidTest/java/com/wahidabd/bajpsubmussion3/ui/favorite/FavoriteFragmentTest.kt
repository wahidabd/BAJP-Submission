package com.wahidabd.bajpsubmussion3.ui.favorite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.wahidabd.bajpsubmussion3.R
import com.wahidabd.bajpsubmussion3.ui.MainActivity
import com.wahidabd.bajpsubmussion3.utils.EspressoIdlingResource
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FavoriteFragmentTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun ternDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun testAInputMovieFavorite() {
        onView(withId(R.id.movieFragment)).perform(click())
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_favorite)).perform(click())
        onView(withId(R.id.rv_movie)).apply { pressBack() }
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        onView(withId(R.id.img_favorite)).perform(click())
    }

    @Test
    fun testBInputTvShowFavorite() {
        onView(withId(R.id.tvFragment)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_favorite)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply { pressBack() }
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        onView(withId(R.id.img_favorite)).perform(click())
    }

    @Test
    fun testCValidationMovieFavorite() {
        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withId(R.id.rv_movie)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }
        onView(withId(R.id.rv_movie)).apply {
            pressBack()
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
            pressBack()
        }
    }

    @Test
    fun testDValidationTvShowFavorite() {
        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }
        onView(withId(R.id.rv_tv_show)).apply {
            pressBack()
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
            pressBack()
        }
    }

    @Test
    fun testERemoveMovieFavorite() {
        onView(withId(R.id.toolBar)).check(matches(isDisplayed()))
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
        onView(withId(R.id.movieFragment)).perform(click())
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_favorite)).perform(click())
    }

    @Test
    fun testFRemoveTvShowFavorite() {
        onView(withId(R.id.toolBar)).check(matches(isDisplayed()))
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
        onView(withId(R.id.tvFragment)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_favorite)).perform(click())
    }

    @Test
    fun testGValidationMovieFavorite() {
        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withId(R.id.rv_movie)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            pressBack()
        }
    }

    @Test
    fun testHValidationTvShowFavorite() {
        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            pressBack()
        }
    }
}
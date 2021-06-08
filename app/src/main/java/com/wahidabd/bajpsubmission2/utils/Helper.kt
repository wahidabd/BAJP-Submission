package com.wahidabd.bajpsubmission2.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object Helper {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "24149183601d3608dcc2154306619711"
    const val MOVIE_TYPE = "movie_type"
    const val TV_TYPE = "tv_type"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"

    private const val RESOURCE = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)
    fun increment() = espressoTestIdlingResource.increment()
    fun decrement() = espressoTestIdlingResource.decrement()
    fun espressoIdlingResource(): IdlingResource = espressoTestIdlingResource
}
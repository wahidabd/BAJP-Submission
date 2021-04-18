package com.wahidabd.bajpsubmission1.ui.home

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp(){
        viewModel = HomeViewModel()
    }

    @Test
    fun getAllMovie() {
        val movieEntity = viewModel.getAllMovie()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity.size)
    }

    @Test
    fun getAllTv() {
        val tvEntity = viewModel.getAllTv()
        assertNotNull(tvEntity)
        assertEquals(10, tvEntity.size)
    }
}
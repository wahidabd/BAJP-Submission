package com.wahidabd.bajpsubmission2.ui.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.wahidabd.bajpsubmission2.DataDummy
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.model.DataList
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @Rule
    @JvmField
    val executable = InstantTaskExecutorRule()

    private var viewModel: MovieViewModel? = null

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataList>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovie() {
        val data = DataDummy.getMovies()
        val movies = MutableLiveData<List<DataList>>()
        movies.value = data

        `when`(repository.getMovies()).thenReturn(movies)
        val movie = viewModel?.getMovies()?.value
        verify(repository).getMovies()
        assertNotNull(movie)
        assertEquals(3, movie?.size)

        viewModel?.getMovies()?.observeForever(observer)
        verify(observer).onChanged(data)
    }
}

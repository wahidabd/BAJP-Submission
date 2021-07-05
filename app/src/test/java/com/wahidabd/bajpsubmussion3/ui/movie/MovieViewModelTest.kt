package com.wahidabd.bajpsubmussion3.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MyRepository

    @Mock
    private lateinit var observer: Observer<List<DataMovie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovie() {
        val dataMovie = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<List<DataMovie>>()
        movie.value = dataMovie
        Mockito.`when`(repository.getMovie()).thenReturn(movie)

        val result = viewModel.getMovie().value
        Mockito.verify(repository).getMovie()
        Assert.assertNotNull(result)
        Assert.assertEquals(10, result?.size)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(dataMovie)
    }
}
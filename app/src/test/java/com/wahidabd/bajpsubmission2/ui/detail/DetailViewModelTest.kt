package com.wahidabd.bajpsubmission2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.wahidabd.bajpsubmission2.DataDummy
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.utils.Helper.MOVIE_TYPE
import com.wahidabd.bajpsubmission2.utils.Helper.TV_TYPE
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dataMovie = DataDummy.getDetailMovie()
    private val idMovie = dataMovie.id.toString()

    private val dataTv = DataDummy.getDetailMovie()
    private val idTv = dataTv.id.toString()

    @get:Rule
    var executable = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var observer: Observer<DataList>

    @Before
    fun setUp(){
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun getDetailMovie(){
        val movie = MutableLiveData<DataList>()
        movie.value = dataMovie

        `when`(repository.getDetailMovie(idMovie)).thenReturn(movie)
        viewModel.setData(idMovie, MOVIE_TYPE)
        val entity = viewModel.getDetail().value as DataList
        verify(repository).getDetailMovie(idMovie)

        assertNotNull(entity)
        assertEquals(dataMovie.id, entity.id)
        assertEquals(dataMovie.title, entity.title)
        assertEquals(dataMovie.backdrop_path, entity.backdrop_path)
        assertEquals(dataMovie.poster_path, entity.poster_path)
        assertEquals(dataMovie.overview, entity.overview)
        assertEquals(dataMovie.release_date, entity.release_date)

        viewModel.getDetail().observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }

    @Test
    fun getDetailTv(){
        val tv = MutableLiveData<DataList>()
        tv.value = dataTv

        `when`(repository.getDetailTv(idTv)).thenReturn(tv)
        viewModel.setData(idTv, TV_TYPE)
        val entity = viewModel.getDetail().value as DataList
        verify(repository).getDetailTv(idTv)

        assertNotNull(entity)
        assertEquals(dataTv.id, entity.id)
        assertEquals(dataTv.name, entity.name)
        assertEquals(dataTv.backdrop_path, entity.backdrop_path)
        assertEquals(dataTv.poster_path, entity.poster_path)
        assertEquals(dataTv.overview, entity.overview)
        assertEquals(dataTv.first_air_date, entity.first_air_date)

        viewModel.getDetail().observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }
}
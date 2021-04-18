package com.wahidabd.bajpsubmission1.ui.detail

import com.wahidabd.bajpsubmission1.data.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    lateinit var viewModel: DetailViewModel
    private val dataMovie = DataDummy.generateDummyMovies()[0]
    private val dataTv = DataDummy.generateDummyTvShows()[0]
    private val movieId = dataMovie.id
    private val tvId = dataTv.id

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.selectedMovie(movieId)
        viewModel.selectedTv(tvId)
    }

    @Test
    fun setMovie(){
        viewModel.selectedMovie(dataMovie.id)
        val movieEntity = viewModel.setMovie()
        assertNotNull(movieEntity)
        assertEquals(dataMovie.id, movieEntity.id)
        assertEquals(dataMovie.title, movieEntity.title)
        assertEquals(dataMovie.description, movieEntity.description)
        assertEquals(dataMovie.realeaseYear, movieEntity.realeaseYear)
        assertEquals(dataMovie.genre, movieEntity.genre)
        assertEquals(dataMovie.imgPoster, movieEntity.imgPoster)
        assertEquals(dataMovie.imgBackground, movieEntity.imgBackground)
    }

    @Test
    fun setTv(){
        viewModel.selectedTv(dataTv.id)
        val tvEntity = viewModel.setTv()
        assertNotNull(tvEntity)
        assertEquals(dataTv.id, tvEntity.id)
        assertEquals(dataTv.title, tvEntity.title)
        assertEquals(dataTv.description, tvEntity.description)
        assertEquals(dataTv.realeaseYear, tvEntity.realeaseYear)
        assertEquals(dataTv.genre, tvEntity.genre)
        assertEquals(dataTv.imgPoster, tvEntity.imgPoster)
        assertEquals(dataTv.imgBackground, tvEntity.imgBackground)
    }

    @Test
    fun getMovie(){
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity.size.toLong())
    }
    @Test
    fun getTv(){
        val tvEntity = viewModel.getTv()
        assertNotNull(tvEntity)
        assertEquals(10, tvEntity.size.toLong())
    }

}
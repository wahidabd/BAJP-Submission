package com.wahidabd.bajpsubmussion3.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.ui.movie.MovieViewModel
import com.wahidabd.bajpsubmussion3.utils.DataDummy
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dataMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dataMovie.id

    private val dataFavorite = DataDummy.generateDummyFavorite()[0]
    private val favoriteId = dataFavorite.id ?: 508943

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MyRepository

    @Mock
    private lateinit var observer: Observer<DataMovie>

    @Mock
    private lateinit var observerFavorite: Observer<DataFavorite>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<DataMovie>()
        movie.value = dataMovie
        Mockito.`when`(repository.getDetailMovie(movieId)).thenReturn(movie)

        val movieModel = viewModel.getMovie(movieId).value
        verify(repository).getDetailMovie(movieId)

        Assert.assertNotNull(movieModel)
        Assert.assertEquals(dataMovie.id, movieModel?.id)
        Assert.assertEquals(dataMovie.title, movieModel?.title)
        Assert.assertEquals(dataMovie.overview, movieModel?.overview)
        Assert.assertEquals(dataMovie.poster_path, movieModel?.poster_path)
        Assert.assertEquals(dataMovie.backdrop_path, movieModel?.backdrop_path)
        Assert.assertEquals(dataMovie.release_date, movieModel?.release_date)

        viewModel.getMovie(movieId).observeForever(observer)
        verify(observer).onChanged(dataMovie)
    }

    @Test
    fun getFavoriteById() {
        val favorite = MutableLiveData<DataFavorite>()
        favorite.value = dataFavorite
        Mockito.`when`(repository.getFavoriteById(favoriteId)).thenReturn(favorite)

        val favoriteModel = viewModel.getFavoriteById(favoriteId).value
        verify(repository).getFavoriteById(favoriteId)

        Assert.assertNotNull(favoriteModel)
        Assert.assertEquals(dataFavorite.id, favoriteModel?.id)
        Assert.assertEquals(dataFavorite.title, favoriteModel?.title)
        Assert.assertEquals(dataFavorite.category, favoriteModel?.category)
        Assert.assertEquals(dataFavorite.poster_path, favoriteModel?.poster_path)
        Assert.assertEquals(dataFavorite.backdrop_path, favoriteModel?.backdrop_path)
        Assert.assertEquals(dataFavorite.release_date, favoriteModel?.release_date)

        viewModel.getFavoriteById(favoriteId).observeForever(observerFavorite)
        verify(observerFavorite).onChanged(dataFavorite)
    }

    @Test
    fun insertFavorite() {
        viewModel.insertFavorite(dataFavorite)
        verify(repository, times(1)).insertFavorite(dataFavorite)
    }

    @Test
    fun deleteFavorite() {
        viewModel.deleteFavoriteById(favoriteId)
        verify(repository, times(1)).deleteFavoriteById(favoriteId)
    }
}
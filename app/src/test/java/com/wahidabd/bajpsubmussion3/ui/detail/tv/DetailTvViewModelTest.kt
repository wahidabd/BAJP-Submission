package com.wahidabd.bajpsubmussion3.ui.detail.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
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
class DetailTvViewModelTest {
    private lateinit var viewModel: DetailTvViewModel
    private val dataTv = DataDummy.generateDummyTv()[0]
    private val tvId = dataTv.id

    private val dataFavorite = DataDummy.generateDummyFavorite()[0]
    private val favoriteId = dataFavorite.id ?: 508943

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MyRepository

    @Mock
    private lateinit var observer: Observer<DataTv>

    @Mock
    private lateinit var observerFavorite: Observer<DataFavorite>

    @Before
    fun setUp() {
        viewModel = DetailTvViewModel(repository)
    }

    @Test
    fun getDetailMovie() {
        val tv = MutableLiveData<DataTv>()
        tv.value = dataTv
        Mockito.`when`(repository.getDetailTv(tvId)).thenReturn(tv)

        val tvModel = viewModel.getTv(tvId).value
        verify(repository).getDetailTv(tvId)

        Assert.assertNotNull(tvModel)
        Assert.assertEquals(dataTv.id, tvModel?.id)
        Assert.assertEquals(dataTv.name, tvModel?.name)
        Assert.assertEquals(dataTv.overview, tvModel?.overview)
        Assert.assertEquals(dataTv.poster_path, tvModel?.poster_path)
        Assert.assertEquals(dataTv.backdrop_path, tvModel?.backdrop_path)
        Assert.assertEquals(dataTv.first_air_date, tvModel?.first_air_date)

        viewModel.getTv(tvId).observeForever(observer)
        verify(observer).onChanged(dataTv)
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
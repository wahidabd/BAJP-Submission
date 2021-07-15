package com.wahidabd.bajpsubmussion3.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.*
import com.wahidabd.bajpsubmussion3.data.local.LocalDataSource
import com.wahidabd.bajpsubmussion3.data.remote.RemoteDataSource
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import com.wahidabd.bajpsubmussion3.utils.DataDummy
import com.wahidabd.bajpsubmussion3.utils.LiveDataTest
import com.wahidabd.bajpsubmussion3.utils.PagedList
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MyRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecuteRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val repository = FakeRepository(remote, local)

    private val dataListFavorite = DataDummy.generateDummyFavorite()
    private val dataFavorite = DataDummy.generateDummyFavorite()[0]
    private val favoriteId = dataFavorite.id ?: 508943

    private val dataListMovie = DataDummy.generateDummyMovie()
    private val dataMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dataMovie.id

    private val dataListTv = DataDummy.generateDummyTv()
    private val dataTv = DataDummy.generateDummyTv()[0]
    private val tvId = dataTv.id

    @Test
    fun testGetFavorite() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataFavorite>
        Mockito.`when`(local.getFavorite()).thenReturn(dataSourceFactory)
        repository.getFavorite()

        val result = PagedList.mockPagedList(DataDummy.generateDummyFavorite())
        verify(local).getFavorite()
        assertNotNull(result)
        assertEquals(dataListFavorite.size, result.size)
    }

    @Test
    fun testGetFavoriteById() {
        val favorite = MutableLiveData<DataFavorite>()
        Mockito.`when`(favoriteId.let { local.getFavoriteById(it) }).thenReturn(favorite)
        repository.getFavoriteById(favoriteId)
        verify(local).getFavoriteById(favoriteId)

        val favoriteModel = DataDummy.generateDummyFavorite()[0]
        assertNotNull(favoriteModel)
        assertEquals(dataFavorite.id, favoriteModel.id)
    }

    @Test
    fun testInsertFavorite() {
        repository.insertFavorite(dataFavorite)
        verify(local, times(1)).insertFavorite(dataFavorite)
    }

    @Test
    fun testDeleteFavoriteById() {
        favoriteId.let { repository.deleteFavoriteById(it) }
        verify(local, times(1)).deleteFavoriteById(favoriteId)
    }

    @Test
    fun testGetMovie() {
        doAnswer {
            val callback = it.arguments[0] as DataCallback<List<DataMovie>>
            callback.onDataReceived(dataListMovie)
            null
        }.`when`(remote).getMovie(any())

        val result = LiveDataTest.getValue(repository.getMovie())
        assertEquals(dataListMovie.size, result.size)
    }


    @Test
    fun testGetDetailMovie() {
        doAnswer {
            val callback = it.arguments[1] as DataCallback<DataMovie>
            callback.onDataReceived(dataMovie)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val result = LiveDataTest.getValue(repository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(result)
        assertEquals(dataMovie.id, result.id)
    }

    @Test
    fun testGetTv() {
        doAnswer {
            val callback = it.arguments[0] as DataCallback<List<DataTv>>
            callback.onDataReceived(dataListTv)
            null
        }.`when`(remote).getTv(any())

        val result = LiveDataTest.getValue(repository.getTv())
        assertEquals(dataListTv.size, result.size)
    }

    @Test
    fun testGetDetailTv() {
        doAnswer {
            val callback = it.arguments[1] as DataCallback<DataTv>
            callback.onDataReceived(dataTv)
            null
        }.`when`(remote).getDetailTv(eq(tvId), any())

        val result = LiveDataTest.getValue(repository.getDetailTv(tvId))
        verify(remote).getDetailTv(eq(tvId), any())
        assertNotNull(result)
        assertEquals(dataTv.id, result.id)
    }
}
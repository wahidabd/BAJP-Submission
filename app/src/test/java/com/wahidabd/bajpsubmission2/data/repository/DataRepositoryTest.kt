package com.wahidabd.bajpsubmission2.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wahidabd.bajpsubmission2.DataDummy
import com.wahidabd.bajpsubmission2.LiveDataTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DataRepositoryTest {

    @Rule
    @JvmField
    var executor = InstantTaskExecutorRule()

    private val localRepository = mock(LocalRepository::class.java)
    private val remoteRepository = mock(RemoteRepository::class.java)
    private val dataDummy = DataDummyRepository(localRepository, remoteRepository)

    private val movieList = DataDummy.getMovies()
    private val movieId = DataDummy.getDetailMovie().id.toString()
    private val tvList = DataDummy.getTvShows()
    private val tvId = DataDummy.getDetailTvShow().id.toString()

    private fun <T> anyOf(type: Class<T>): T = any(type)
    private fun <T> enqOf(obj: T): T = eq(obj)

    @Test
    fun testGetMovies() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetMovies
            callback.response(movieList)
            null
        }.`when`(remoteRepository).getMovies(anyOf(RemoteRepository.GetMovies::class.java))
        val result = LiveDataTest.getValue(dataDummy.getMovies())
        assertEquals(movieList.size, result.size)
    }

    @Test
    fun testGetDetailMovie() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetDetailMovie
            callback.response(movieList[0])
            null
        }.`when`(remoteRepository).getDetailMovie(
            enqOf(movieId),
            anyOf(RemoteRepository.GetDetailMovie::class.java)
        )
    }

    @Test
    fun testGetTv() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetTV
            callback.response(tvList)
            null
        }.`when`(remoteRepository).getTv(anyOf(RemoteRepository.GetTV::class.java))
        val result = LiveDataTest.getValue(dataDummy.getTv())
        assertEquals(movieList.size, result.size)
    }

    @Test
    fun testGetDetailTv() {
        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetDetailTv
            callback.response(tvList[0])
            null
        }.`when`(remoteRepository).getDetailTv(
            enqOf(tvId),
            anyOf(RemoteRepository.GetDetailTv::class.java)
        )
    }
}
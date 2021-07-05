package com.wahidabd.bajpsubmussion3.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
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
class TvViewModelTest {
    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MyRepository

    @Mock
    private lateinit var observer: Observer<List<DataTv>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(repository)
    }

    @Test
    fun getMovie() {
        val dataTv = DataDummy.generateDummyTv()
        val tv = MutableLiveData<List<DataTv>>()
        tv.value = dataTv
        Mockito.`when`(repository.getTv()).thenReturn(tv)

        val result = viewModel.getTv().value
        Mockito.verify(repository).getTv()
        Assert.assertNotNull(result)
        Assert.assertEquals(10, result?.size)

        viewModel.getTv().observeForever(observer)
        Mockito.verify(observer).onChanged(dataTv)
    }
}
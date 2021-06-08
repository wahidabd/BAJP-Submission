package com.wahidabd.bajpsubmission2.ui.home.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.wahidabd.bajpsubmission2.DataDummy
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.model.DataList
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    @Rule
    @JvmField
    val executable = InstantTaskExecutorRule()

    private var viewModel: TvViewModel? = null

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataList>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(repository)
    }

    @Test
    fun getTv() {
        val data = DataDummy.getTvShows()
        val tvs = MutableLiveData<List<DataList>>()
        tvs.value = data

        `when`(repository.getTv()).thenReturn(tvs)
        val tv = viewModel?.getTv()?.value
        verify(repository).getTv()
        Assert.assertNotNull(tv)
        Assert.assertEquals(3, tv?.size)

        viewModel?.getTv()?.observeForever(observer)
        verify(observer).onChanged(data)
    }
}
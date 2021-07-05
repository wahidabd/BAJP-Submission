package com.wahidabd.bajpsubmussion3.ui.favorite.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.ui.favorite.FavoriteViewModel
import com.wahidabd.bajpsubmussion3.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors


@RunWith(MockitoJUnitRunner::class)
class FavoriteTvFragmentTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MyRepository

    @Mock
    private lateinit var observer: Observer<PagedList<DataFavorite>>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(repository)
    }

    @Test
    fun getFavorite() {
        val favorite = MutableLiveData<PagedList<DataFavorite>>()
        favorite.value = PagedTestDataSources.snapshot(DataDummy.generateDummyFavorite())
        Mockito.`when`(repository.getFavorite()).thenReturn(favorite)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(favorite.value)

        val expectedValue = favorite.value
        val actualValue = viewModel.getMovie().value
        Assert.assertEquals(expectedValue, actualValue)
        Assert.assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        Assert.assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun getFavoriteEmpty() {
        val favorite = MutableLiveData<PagedList<DataFavorite>>()
        favorite.value = PagedTestDataSources.snapshot()
        Mockito.`when`(repository.getFavorite()).thenReturn(favorite)

        viewModel.getMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(favorite.value)

        val actualValueDataSize = viewModel.getMovie().value?.size
        Assert.assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    class PagedTestDataSources private constructor(private val items: List<DataFavorite>) :
        PositionalDataSource<DataFavorite>() {
        companion object {
            fun snapshot(items: List<DataFavorite> = listOf()): PagedList<DataFavorite> {
                return PagedList.Builder(PagedTestDataSources(items), 5)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<DataFavorite>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(
            params: LoadRangeParams,
            callback: LoadRangeCallback<DataFavorite>
        ) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}
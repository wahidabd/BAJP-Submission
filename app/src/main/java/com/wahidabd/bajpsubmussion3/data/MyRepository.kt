package com.wahidabd.bajpsubmussion3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wahidabd.bajpsubmussion3.data.local.LocalDataSource
import com.wahidabd.bajpsubmussion3.data.remote.RemoteDataSource
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyRepository @Inject constructor(private val remote: RemoteDataSource, private val local: LocalDataSource) {

    //Local
    fun getFavorite(): LiveData<PagedList<DataFavorite>> =
        LivePagedListBuilder(local.getFavorite(), 5).build()

    fun getFavoriteById(id: Int) = local.getFavoriteById(id)

    fun insertFavorite(data: DataFavorite) = local.insertFavorite(data)

    fun deleteFavoriteById(id: Int) = local.deleteFavoriteById(id)


    //Api DBMOVIE
    fun getMovie(): LiveData<List<DataMovie>>{
        val data = MutableLiveData<List<DataMovie>>()
        remote.getMovie(object : DataCallback<List<DataMovie>> {
            override fun onDataReceived(response: List<DataMovie>) {
                data.postValue(response)
            }
        })
        return data
    }

    fun getDetailMovie(id: Int?): LiveData<DataMovie>{
        val data = MutableLiveData<DataMovie>()
        remote.getDetailMovie(id, object : DataCallback<DataMovie> {
            override fun onDataReceived(response: DataMovie) {
                data.postValue(response)
            }
        })
        return data
    }

    fun getTv(): LiveData<List<DataTv>>{
        val data = MutableLiveData<List<DataTv>>()
        remote.getTv(object : DataCallback<List<DataTv>> {
            override fun onDataReceived(response: List<DataTv>) {
                data.postValue(response)
            }
        })
        return data
    }

    fun getDetailTv(id: Int?): LiveData<DataTv>{
        val data = MutableLiveData<DataTv>()
        remote.getDetailTv(id, object : DataCallback<DataTv> {
            override fun onDataReceived(response: DataTv) {
                data.postValue(response)
            }
        })
        return data
    }
}
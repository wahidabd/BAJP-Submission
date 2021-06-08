package com.wahidabd.bajpsubmission2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wahidabd.bajpsubmission2.data.source.DataSource
import com.wahidabd.bajpsubmission2.model.DataList


open class DataDummyRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository): DataSource {
    override fun getMovies(): LiveData<List<DataList>> {
        val dataList = MutableLiveData<List<DataList>>()
        remoteRepository.getMovies(object : RemoteRepository.GetMovies{
            override fun response(response: List<DataList>) {
                dataList.postValue(response)
            }
        })
        return dataList
    }

    override fun getDetailMovie(id: String): LiveData<DataList> {
        val data = MutableLiveData<DataList>()
        remoteRepository.getDetailMovie(id, object : RemoteRepository.GetDetailMovie{
            override fun response(response: DataList) {
                data.postValue(response)
            }
        })
        return data
    }

    override fun getTv(): LiveData<List<DataList>> {
        val dataList = MutableLiveData<List<DataList>>()
        remoteRepository.getTv(object : RemoteRepository.GetTV{
            override fun response(response: List<DataList>) {
                dataList.postValue(response)
            }
        })
        return dataList
    }

    override fun getDetailTv(id: String): LiveData<DataList> {
        val data = MutableLiveData<DataList>()
        remoteRepository.getDetailTv(id, object : RemoteRepository.GetDetailTv{
            override fun response(response: DataList) {
                data.postValue(response)
            }
        })
        return data
    }
}
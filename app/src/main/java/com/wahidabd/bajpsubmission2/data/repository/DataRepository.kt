package com.wahidabd.bajpsubmission2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wahidabd.bajpsubmission2.data.source.DataSource
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.model.DataResponse

class DataRepository(local: LocalRepository, private val remote: RemoteRepository) : DataSource {

    companion object{
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(local: LocalRepository, remote: RemoteRepository): DataRepository?{
            if(INSTANCE == null){
                synchronized(DataRepository::class.java){
                    if (INSTANCE == null){
                        INSTANCE = DataRepository(local, remote)
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun getMovies(): LiveData<List<DataList>> {
        val dataList = MutableLiveData<List<DataList>>()
        remote.getMovies(object : RemoteRepository.GetMovies{
            override fun response(response: List<DataList>) {
                dataList.postValue(response)
            }
        })
        return dataList
    }

    override fun getDetailMovie(id: String): LiveData<DataList> {
        val data = MutableLiveData<DataList>()
        remote.getDetailMovie(id, object : RemoteRepository.GetDetailMovie{
            override fun response(response: DataList) {
                data.postValue(response)
            }
        })
        return data
    }

    override fun getTv(): LiveData<List<DataList>> {
        val dataList = MutableLiveData<List<DataList>>()
        remote.getTv(object : RemoteRepository.GetTV{
            override fun response(response: List<DataList>) {
                dataList.postValue(response)
            }
        })

        return dataList
    }

    override fun getDetailTv(id: String): LiveData<DataList> {
        val data = MutableLiveData<DataList>()
        remote.getDetailTv(id, object : RemoteRepository.GetDetailTv{
            override fun response(response: DataList) {
                data.postValue(response)
            }
        })
        return data
    }


}
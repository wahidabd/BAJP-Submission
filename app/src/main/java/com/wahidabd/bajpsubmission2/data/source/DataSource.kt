package com.wahidabd.bajpsubmission2.data.source

import androidx.lifecycle.LiveData
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.model.DataResponse

interface DataSource {
    fun getMovies(): LiveData<List<DataList>>
    fun getDetailMovie(id: String): LiveData<DataList>
    fun getTv(): LiveData<List<DataList>>
    fun getDetailTv(id: String): LiveData<DataList>
}
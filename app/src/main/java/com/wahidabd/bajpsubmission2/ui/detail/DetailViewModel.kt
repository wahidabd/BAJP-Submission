package com.wahidabd.bajpsubmission2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.utils.Helper.MOVIE_TYPE
import com.wahidabd.bajpsubmission2.utils.Helper.TV_TYPE

class DetailViewModel(private val repository: DataRepository) : ViewModel() {
    private lateinit var dataDetail: LiveData<DataList>

    fun setData(id: String, type: String){
        when(type){
            MOVIE_TYPE -> dataDetail = repository.getDetailMovie(id)
            TV_TYPE -> dataDetail = repository.getDetailTv(id)
        }
    }

    fun getDetail() = dataDetail
}
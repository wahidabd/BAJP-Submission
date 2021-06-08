package com.wahidabd.bajpsubmission2.ui.home.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.model.DataList

class TvViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getTv() = dataRepository.getTv()
}
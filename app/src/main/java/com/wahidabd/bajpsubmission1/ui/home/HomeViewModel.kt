package com.wahidabd.bajpsubmission1.ui.home

import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmission1.data.DataDummy
import com.wahidabd.bajpsubmission1.model.DataEntity

class HomeViewModel : ViewModel() {
    fun getAllMovie(): List<DataEntity> = DataDummy.generateDummyMovies()
    fun getAllTv(): List<DataEntity> = DataDummy.generateDummyTvShows()
}
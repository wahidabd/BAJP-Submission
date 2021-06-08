package com.wahidabd.bajpsubmission2.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.model.DataList

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovies()= dataRepository.getMovies()
}
package com.wahidabd.bajpsubmussion3.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    fun getMovie(): LiveData<List<DataMovie>> = repository.getMovie()
}
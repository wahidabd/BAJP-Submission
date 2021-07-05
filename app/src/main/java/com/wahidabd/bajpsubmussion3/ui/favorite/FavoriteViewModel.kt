package com.wahidabd.bajpsubmussion3.ui.favorite

import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmussion3.data.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    fun getMovie() = repository.getFavorite()
}
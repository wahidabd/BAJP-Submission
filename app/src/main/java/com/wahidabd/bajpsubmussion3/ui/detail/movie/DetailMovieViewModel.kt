package com.wahidabd.bajpsubmussion3.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    fun getMovie(id: Int?): LiveData<DataMovie> = repository.getDetailMovie(id)

    fun getFavoriteById(id: Int) = repository.getFavoriteById(id)

    fun insertFavorite(data: DataFavorite) = repository.insertFavorite(data)

    fun deleteFavoriteById(id: Int) = repository.deleteFavoriteById(id)
}
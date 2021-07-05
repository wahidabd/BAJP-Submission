package com.wahidabd.bajpsubmussion3.ui.detail.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailTvViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    fun getTv(id: Int?): LiveData<DataTv> = repository.getDetailTv(id)

    fun getFavoriteById(id: Int) = repository.getFavoriteById(id)

    fun insertFavorite(data: DataFavorite) = repository.insertFavorite(data)

    fun deleteFavoriteById(id: Int) = repository.deleteFavoriteById(id)
}
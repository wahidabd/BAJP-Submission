package com.wahidabd.bajpsubmussion3.data.local

import androidx.paging.DataSource
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val database: MyDatabase) {

    fun getFavorite(): DataSource.Factory<Int, DataFavorite> = database.favoriteDao().getAllFavorite()

    fun getFavoriteById(id: Int?) = database.favoriteDao().getFavoriteById(id)

    fun insertFavorite(data: DataFavorite) = database.favoriteDao().insertFavorite(data)

    fun deleteFavoriteById(id: Int?) = database.favoriteDao().deleteFavoriteById(id)
}
package com.wahidabd.bajpsubmussion3.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_entity")
    fun getAllFavorite(): DataSource.Factory<Int, DataFavorite>

    @Query("SELECT * FROM favorite_entity WHERE id = :id")
    fun getFavoriteById(id: Int?):LiveData<DataFavorite>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavorite(data: DataFavorite)

    @Query("DELETE FROM favorite_entity WHERE id = :id")
    fun deleteFavoriteById(id: Int?): Int
}
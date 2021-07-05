package com.wahidabd.bajpsubmussion3.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite

@Database(entities = [DataFavorite::class], version = 3, exportSchema = false)
abstract class MyDatabase : RoomDatabase(){
    abstract fun favoriteDao(): FavoriteDao

    companion object{
        @Volatile
        private var instance: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase =
            instance ?: synchronized(this){
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MyDatabase::class.java, "favorite.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}
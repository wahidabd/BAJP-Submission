package com.wahidabd.bajpsubmission2.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.di.Injection
import com.wahidabd.bajpsubmission2.ui.detail.DetailViewModel
import com.wahidabd.bajpsubmission2.ui.home.movie.MovieViewModel
import com.wahidabd.bajpsubmission2.ui.home.tv.TvViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataRepository: DataRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory? {
            if (INSTANCE == null){
                synchronized(ViewModelFactory::class.java){
                    if (INSTANCE == null)
                        INSTANCE = Injection.movieRepository()?.let { ViewModelFactory(it) }
                }
            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(dataRepository) as T
            modelClass.isAssignableFrom(TvViewModel::class.java) -> TvViewModel(dataRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(dataRepository) as T
            else -> throw IllegalArgumentException("Unknown Viewmodel: ${modelClass.name}" )
        }
    }
}
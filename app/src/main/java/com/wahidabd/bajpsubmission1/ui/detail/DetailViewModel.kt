package com.wahidabd.bajpsubmission1.ui.detail

import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmission1.data.DataDummy
import com.wahidabd.bajpsubmission1.model.DataEntity

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvId: String

    fun selectedMovie(id: String){
        movieId = id
    }

    fun selectedTv(id: String){
        tvId = id
    }

    @Suppress("NAME_SHADOWING")
    fun setMovie(): DataEntity {
        lateinit var movie: DataEntity
        val movieEntity = getMovie()
        for (movieEntity in movieEntity) {
            if (movieEntity.id == movieId){
                movie = movieEntity
            }
        }
        return movie
    }

    @Suppress("NAME_SHADOWING")
    fun setTv(): DataEntity {
        lateinit var tv: DataEntity
        val tvEntity = getTv()
        for (tvEntity in tvEntity) {
            if (tvEntity.id == tvId) {
                tv = tvEntity
            }
        }
        return tv
    }

    fun getMovie(): List<DataEntity> = DataDummy.generateDummyMovies()
    fun getTv(): List<DataEntity> = DataDummy.generateDummyTvShows()
}
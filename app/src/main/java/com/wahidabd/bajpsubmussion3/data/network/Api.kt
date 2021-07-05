package com.wahidabd.bajpsubmussion3.data.network

import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.models.movie.MovieResponse
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import com.wahidabd.bajpsubmussion3.models.tv.TvResponse
import com.wahidabd.bajpsubmussion3.utils.Constant.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("discover/movie?api_key=$API_KEY")
    fun getMovie(): Call<MovieResponse>

    @GET("movie/{id}?api_key=$API_KEY")
    fun getDetailMovie(
        @Path("id") id: Int?,
    ): Call<DataMovie>

    @GET("discover/tv?api_key=$API_KEY")
    fun getTv(): Call<TvResponse>

    @GET("tv/{id}?api_key=$API_KEY")
    fun getDetailTv(
        @Path("id") id: Int?,
    ): Call<DataTv>
}
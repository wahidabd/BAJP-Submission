package com.wahidabd.bajpsubmission2.data.network

import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.model.DataResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String
    ): Call<DataResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<DataList>

    @GET("tv/popular")
    fun getTv(
        @Query("api_key") apiKey: String
    ): Call<DataResponse>

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<DataList>
}
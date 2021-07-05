package com.wahidabd.bajpsubmussion3.data.remote

import android.util.Log
import com.wahidabd.bajpsubmussion3.data.DataCallback
import com.wahidabd.bajpsubmussion3.data.network.Api
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.models.movie.MovieResponse
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import com.wahidabd.bajpsubmussion3.models.tv.TvResponse
import com.wahidabd.bajpsubmussion3.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: Api) {

    fun getMovie(callback: DataCallback<List<DataMovie>>){
        EspressoIdlingResource.increment()
        api.getMovie().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.results?.let { callback.onDataReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("Remote Datasource", t.printStackTrace().toString())
            }
        })
    }

    fun getDetailMovie(id: Int?, callback: DataCallback<DataMovie>){
        EspressoIdlingResource.increment()
        api.getDetailMovie(id).enqueue(object : Callback<DataMovie>{
            override fun onResponse(call: Call<DataMovie>, response: Response<DataMovie>) {
                response.body()?.let { callback.onDataReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DataMovie>, t: Throwable) {
                Log.e("Remote Datasource", t.printStackTrace().toString())
            }
        })
    }

    fun getTv(callback: DataCallback<List<DataTv>>){
        EspressoIdlingResource.increment()
        api.getTv().enqueue(object : Callback<TvResponse>{
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                response.body()?.results?.let { callback.onDataReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e("Remote Datasource", t.printStackTrace().toString())
            }

        })
    }

    fun getDetailTv(id: Int?, callback: DataCallback<DataTv>){
        EspressoIdlingResource.increment()
        api.getDetailTv(id).enqueue(object : Callback<DataTv>{
            override fun onResponse(call: Call<DataTv>, response: Response<DataTv>) {
                response.body()?.let { callback.onDataReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DataTv>, t: Throwable) {
                Log.e("Remote Datasource", t.printStackTrace().toString())
            }
        })
    }
}
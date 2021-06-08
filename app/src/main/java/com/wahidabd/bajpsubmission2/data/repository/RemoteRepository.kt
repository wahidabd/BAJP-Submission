package com.wahidabd.bajpsubmission2.data.repository

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.TimeFormatException
import com.wahidabd.bajpsubmission2.data.network.RetrofitClient
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.model.DataResponse
import com.wahidabd.bajpsubmission2.utils.Helper
import com.wahidabd.bajpsubmission2.utils.Helper.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class RemoteRepository(retrofit: RetrofitClient){
    private var handle = Handler(Looper.getMainLooper())
    private var retrofit = RetrofitClient

    companion object{
        private var INSTANCE: RemoteRepository? = null
        private val TAG = RemoteRepository::class.java.toString()
        private const val TIME: Long = 1500

        fun getInstance(retrofit: RetrofitClient): RemoteRepository{
            if (INSTANCE == null) INSTANCE = RemoteRepository(retrofit)
            return INSTANCE!!
        }
    }

    interface  GetMovies{
        fun response(response: List<DataList>)
    }

    interface GetDetailMovie{
        fun response(response: DataList)
    }

    interface GetTV{
        fun response(response: List<DataList>)
    }

    interface GetDetailTv{
        fun response(response: DataList)
    }

    fun getMovies(getMovies: GetMovies){
        Helper.increment()
        handle.postDelayed({
            retrofit.retrofitClient().getMovies(API_KEY).enqueue(object : Callback<DataResponse>{
                override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                    response.body()?.results?.let {getMovies.response(it)}
                    Helper.decrement()
                }

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

            })
        }, TIME)
    }

    fun getDetailMovie(id: String, getDetailMovie: GetDetailMovie){
        Helper.increment()
        handle.postDelayed({
            retrofit.retrofitClient().getDetailMovie(id, API_KEY).enqueue(object : Callback<DataList>{
                override fun onResponse(call: Call<DataList>, response: Response<DataList>) {
                    response.body()?.let { getDetailMovie.response(it) }
                    Helper.decrement()
                }

                override fun onFailure(call: Call<DataList>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

            })
        }, TIME)
    }

    fun getTv(getTV: GetTV){
        Helper.increment()
        handle.postDelayed({
            retrofit.retrofitClient().getTv(API_KEY).enqueue(object : Callback<DataResponse>{
                override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                    response.body()?.results?.let {
                        getTV.response(it)
                    }
                    Helper.decrement()
                }

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }
            })
        }, TIME)
    }

    fun getDetailTv(id: String, getDetailTv: GetDetailTv){
        Helper.increment()
        handle.postDelayed({
            retrofit.retrofitClient().getDetailTv(id, API_KEY).enqueue(object : Callback<DataList>{
                override fun onResponse(call: Call<DataList>, response: Response<DataList>) {
                    response.body()?.let { getDetailTv.response(it) }
                    Helper.decrement()
                }

                override fun onFailure(call: Call<DataList>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

            })
        }, TIME)
    }
}
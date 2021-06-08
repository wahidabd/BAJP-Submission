package com.wahidabd.bajpsubmission2.di

import com.wahidabd.bajpsubmission2.data.network.RetrofitClient
import com.wahidabd.bajpsubmission2.data.repository.DataRepository
import com.wahidabd.bajpsubmission2.data.repository.LocalRepository
import com.wahidabd.bajpsubmission2.data.repository.RemoteRepository

object Injection {
    fun movieRepository(): DataRepository? {
        val local = LocalRepository()
        val remote = RemoteRepository.getInstance(RetrofitClient)
        return DataRepository.getInstance(local, remote)
    }
}
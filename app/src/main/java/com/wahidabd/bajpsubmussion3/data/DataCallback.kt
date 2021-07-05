package com.wahidabd.bajpsubmussion3.data

interface DataCallback<T>{
    fun onDataReceived(response: T)
}
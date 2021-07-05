package com.wahidabd.bajpsubmussion3.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wahidabd.bajpsubmussion3.data.MyRepository
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    fun getTv(): LiveData<List<DataTv>> = repository.getTv()
}
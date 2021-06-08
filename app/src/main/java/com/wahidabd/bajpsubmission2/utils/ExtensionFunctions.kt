package com.wahidabd.bajpsubmission2.utils

import android.view.View
import android.widget.ProgressBar

fun progressBar(active: Boolean, progress: ProgressBar){
    if (active) progress.visibility = View.VISIBLE
    else progress.visibility = View.GONE
}
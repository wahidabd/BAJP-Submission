package com.wahidabd.bajpsubmussion3.models.tv

import com.wahidabd.bajpsubmussion3.models.movie.DataMovie

data class TvResponse(
    val results: List<DataTv>? = null,
    val page: Int? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)
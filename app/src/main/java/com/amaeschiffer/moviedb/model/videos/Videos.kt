package com.amaeschiffer.moviedb.model.videos

import com.amaeschiffer.moviedb.model.videos.Result

data class Videos(
    var id: Int,
    var results: List<Result>
)
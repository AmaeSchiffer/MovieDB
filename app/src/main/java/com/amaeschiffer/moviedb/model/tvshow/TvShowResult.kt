package com.amaeschiffer.moviedb.model.tvshow

data class TvShowResult(
    var page: Int,
    var results: List<ResultTvShow>,
    var totalPages: Int,
    var totalResults: Int
)
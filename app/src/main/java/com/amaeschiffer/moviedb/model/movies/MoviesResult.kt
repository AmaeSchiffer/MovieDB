package com.amaeschiffer.moviedb.model.movies

data class MoviesResult(
    val page: Int,
    val results: List<ResultMovies>,
    val total_pages: Int,
    val total_results: Int
)
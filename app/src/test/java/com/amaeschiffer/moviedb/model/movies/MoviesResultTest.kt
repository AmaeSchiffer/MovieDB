package com.amaeschiffer.moviedb.model.movies

import com.amaeschiffer.moviedb.data.TMDBData
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesResultTest {
    private lateinit var moviesResult: MoviesResult
    private val tmdbData = TMDBData()

    @Test
    fun getResults() {
        val resultMovies:List<ResultMovies> = moviesResult.results
        assertNotNull(resultMovies)
        assertEquals(5, resultMovies.size.toLong())
    }

    @Before
    fun setUp(){
        moviesResult = MoviesResult(tmdbData.getMovieJson().page, tmdbData.getMovieJson().results, tmdbData.getMovieJson().total_pages, tmdbData.getMovieJson().total_results)
    }
}
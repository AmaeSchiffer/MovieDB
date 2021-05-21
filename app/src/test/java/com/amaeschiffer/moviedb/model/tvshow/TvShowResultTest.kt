package com.amaeschiffer.moviedb.model.tvshow

import com.amaeschiffer.moviedb.data.TMDBData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowResultTest {

    private lateinit var tvShowResult: TvShowResult
    private val tmdbData = TMDBData()

    @Before
    fun setUp(){
        tvShowResult = TvShowResult(tmdbData.getTvShowJson().page, tmdbData.getTvShowJson().results, tmdbData.getTvShowJson().totalPages, tmdbData.getTvShowJson().totalResults)
    }

    @Test
    fun getResults() {
        val resultTvShow:List<ResultTvShow> = tvShowResult.results
        assertNotNull(resultTvShow)
        assertEquals(20, resultTvShow.size.toLong())
    }
}
package com.amaeschiffer.moviedb.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amaeschiffer.moviedb.data.TMDBData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock

@RunWith(JUnit4::class)
class DetailActivityViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbData: TMDBData

    @Mock
    private lateinit var detailActivityViewModel: DetailActivityViewModel

    @Before
    fun setUp(){
        detailActivityViewModel = DetailActivityViewModel()
        tmdbData = TMDBData()
    }

    @Test
    fun getVideos(){
        val moviesId = tmdbData.getMovieJson().results[0].id
        detailActivityViewModel.loadData(moviesId)
        detailActivityViewModel.getVideo().observeForever {
            print(it.results[0].key)
            assertNotNull(it.results[0].key)
        }
    }
}
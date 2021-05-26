package com.amaeschiffer.moviedb.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HomeActivityViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var homeActivityViewModel: HomeActivityViewModel

    @Before
    fun setUp(){
        homeActivityViewModel = HomeActivityViewModel()
    }

    @Test
    fun getMovies(){
        homeActivityViewModel.loadDataMovie()
        val movies = homeActivityViewModel.getMovies()
        assertNotNull(movies)
        assertEquals(20, movies?.value?.results?.size)
    }

    @Test
    fun getTvShow(){
        homeActivityViewModel.loadDataTv()
        val tvShow = homeActivityViewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(20, tvShow?.value?.results?.size)
    }
}
package com.amaeschiffer.moviedb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaeschiffer.moviedb.data.TMDBData
import com.amaeschiffer.moviedb.model.movies.MoviesResult
import com.amaeschiffer.moviedb.model.tvshow.TvShowResult

class HomeActivityViewModel : ViewModel() {
    private var resultTvShow:MutableLiveData<TvShowResult>? = MutableLiveData()
    private var resultMovies:MutableLiveData<MoviesResult>? = MutableLiveData()
    private val tmdbData = TMDBData()

    fun loadDataTv(){
        resultTvShow?.postValue(tmdbData.getTvShowJson())
    }

    fun loadDataMovie(){
        resultMovies?.postValue(tmdbData.getMovieJson())
    }

    fun getTvShow() : MutableLiveData<TvShowResult>?{
        return resultTvShow
    }

    fun getMovies() : MutableLiveData<MoviesResult>?{
        return resultMovies
    }
}
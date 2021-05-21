package com.amaeschiffer.moviedb.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaeschiffer.moviedb.R
import com.amaeschiffer.moviedb.adapter.MovieShowAdapter
import com.amaeschiffer.moviedb.model.movies.ResultMovies
import com.amaeschiffer.moviedb.viewmodel.HomeActivityViewModel
import kotlinx.android.synthetic.main.fragment_movies.view.*


class MoviesFragment : Fragment() {

    companion object{
        val movieShow = "TVSHOW"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_movies, container, false)
        v.rvMovies.setHasFixedSize(true)
        v.rvMovies.layoutManager = LinearLayoutManager(activity)
        val adapter = MovieShowAdapter(context)
        adapter.notifyDataSetChanged()
        v.rvMovies.adapter = adapter
        val homeActivityViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            HomeActivityViewModel::class.java)
        homeActivityViewModel.loadDataMovie()
        homeActivityViewModel.getMovies()?.observe(this, {
            adapter.setData(it.results as ArrayList<ResultMovies>)
        })
        return v
    }
}
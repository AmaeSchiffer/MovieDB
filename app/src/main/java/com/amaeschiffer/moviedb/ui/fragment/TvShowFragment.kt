package com.amaeschiffer.moviedb.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaeschiffer.moviedb.R
import com.amaeschiffer.moviedb.adapter.TvShowAdapter
import com.amaeschiffer.moviedb.model.tvshow.ResultTvShow
import com.amaeschiffer.moviedb.viewmodel.HomeActivityViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.view.*

class TvShowFragment : Fragment() {

    companion object{
        val tvShow = "TVSHOW"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_tv_show, container, false)
        v.rvTvShow.setHasFixedSize(true)
        v.rvTvShow.layoutManager = LinearLayoutManager(activity)
        val adapter = TvShowAdapter(context)
        adapter.notifyDataSetChanged()
        v.rvTvShow.adapter = adapter
        val homeActivityViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeActivityViewModel::class.java)
        homeActivityViewModel.loadDataTv()
        homeActivityViewModel.getTvShow()?.observe(this, {
            adapter.setData(it.results as ArrayList<ResultTvShow>)
        })
        return v
    }
}
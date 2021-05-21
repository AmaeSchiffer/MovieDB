package com.amaeschiffer.moviedb.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.lifecycle.ViewModelProvider
import com.amaeschiffer.moviedb.R
import com.amaeschiffer.moviedb.model.movies.ResultMovies
import com.amaeschiffer.moviedb.model.tvshow.ResultTvShow
import com.amaeschiffer.moviedb.util.Utils
import com.amaeschiffer.moviedb.viewmodel.DetailActivityViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val key = intent.extras?.getString("key")
        val result = intent.getSerializableExtra(key)
        val util = Utils()
        if(result is ResultMovies){
            Glide.with(this).load(util.getURL(result.backdrop_path)).into(backdropDetail)
            nameDetail.text = result.title
            yearDetail.text = util.convertDate(result.release_date)
            overviewDetail.text = result.overview
            val detailActivityViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                DetailActivityViewModel::class.java)
            detailActivityViewModel.loadData(result.id)
            linearWatchTrailer.setOnClickListener {
                detailActivityViewModel.getVideo().observe(this, {
                    if(it.results[0].site.equals("youtube", ignoreCase = true)){
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=${it.results[0].key}")
                            )
                        )
                    }else if(it.results[0].site.equals("vimeo", ignoreCase = true)){
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.vimeo.com/${it.results[0].key}")
                            )
                        )
                    }
                })
            }
        }else if (result is ResultTvShow){
            Glide.with(this).load(util.getURL(result.backdrop_path.toString())).into(backdropDetail)
            nameDetail.text = result.name
            yearDetail.text = util.convertDate(result.first_air_date.toString())
            overviewDetail.text = result.overview
            linearWatchTrailer.visibility = View.INVISIBLE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
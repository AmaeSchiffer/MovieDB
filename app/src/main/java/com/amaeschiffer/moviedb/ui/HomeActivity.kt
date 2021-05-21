package com.amaeschiffer.moviedb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amaeschiffer.moviedb.R
import com.amaeschiffer.moviedb.ui.fragment.MoviesFragment
import com.amaeschiffer.moviedb.ui.fragment.TvShowFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutHome, MoviesFragment()).commit()
        }
        supportActionBar?.hide()
        bottomNavbarHome.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_movies -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayoutHome, MoviesFragment()).commit()
                }
                R.id.action_tvshow -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayoutHome, TvShowFragment()).commit()
                }
            }
            true
        }
    }
}
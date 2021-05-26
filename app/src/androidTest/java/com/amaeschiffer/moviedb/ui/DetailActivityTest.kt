package com.amaeschiffer.moviedb.ui

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.amaeschiffer.moviedb.R
import com.amaeschiffer.moviedb.data.TMDBData
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

@RunWith(AndroidJUnit4ClassRunner::class)
class DetailActivityTest {
    private val moviesResults = TMDBData().getMovieJson()

    @Before
    fun setup(){
        ActivityScenario.launch(SplashScreen::class.java)
    }

    @Test
    fun checkDetailActivityWithRandomClickMovieItemRv(){
        onView(withId(R.id.homeActivity)).check(matches(isDisplayed()))
        onView(withId(R.id.action_movies)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed()))
        val sizeMovie = moviesResults.results.size
        val randomValue = Random.nextInt(0,sizeMovie-1)
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                randomValue,
                click()
            )
        )
        onView(withId(R.id.activityDetail)).check(matches(isDisplayed()))
    }
}
package com.amaeschiffer.moviedb.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
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

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    private val movies = TMDBData().getMovieJson()
    private val tvShow = TMDBData().getTvShowJson()

    @Before
    fun setup(){
        ActivityScenario.launch(SplashScreen::class.java)
    }

    @Test
    fun checkHomeActivity(){
        onView(withId(R.id.homeActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun performClickedItemRecyclerView(){
        onView(withId(R.id.action_movies)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.activityDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.activityDetail)).perform(pressBack())
        onView(withId(R.id.action_tvshow)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.activityDetail)).check(matches(isDisplayed()))
    }

    @Test
    fun performScrollingRecyclerView(){
        onView(withId(R.id.action_movies)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.results.size)
        )

        onView(withId(R.id.action_tvshow)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShow.results.size)
        )
    }
}
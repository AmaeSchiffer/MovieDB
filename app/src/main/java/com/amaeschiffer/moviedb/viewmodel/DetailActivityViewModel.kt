package com.amaeschiffer.moviedb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaeschiffer.moviedb.model.videos.Videos
import com.amaeschiffer.moviedb.services.VideoServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailActivityViewModel : ViewModel() {
    private val baseURL = "https://api.themoviedb.org/3/"
    private val apiKey = "fecd20512627569bdfc2f6a4eb7c6462"

    private var videos : MutableLiveData<Videos> = MutableLiveData()

    fun loadData(id: Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(VideoServices::class.java)
        val call = service.getMetadataVideo(id, apiKey)
        call.enqueue(object : Callback<Videos>{
            override fun onResponse(call: Call<Videos>, response: Response<Videos>) {
                videos.postValue(response.body())
            }

            override fun onFailure(call: Call<Videos>, t: Throwable) {
            }

        })
    }
    fun getVideo() : MutableLiveData<Videos> {
        return videos
    }
}
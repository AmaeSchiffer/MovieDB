package com.amaeschiffer.moviedb.services

import com.amaeschiffer.moviedb.model.videos.Videos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VideoServices {
    @GET("movie/{id}/videos")
    fun getMetadataVideo(@Path("id") id: Int , @Query("api_key") apiKey: String ) : Call<Videos>
}
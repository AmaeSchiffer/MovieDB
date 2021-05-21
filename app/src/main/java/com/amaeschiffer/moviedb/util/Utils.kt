package com.amaeschiffer.moviedb.util

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    fun convertDate(stringDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
        val date: Date? = inputFormat.parse(stringDate)
        return outputFormat.format(date!!)
    }

    fun getURL(url : String) : String {
        return "https://image.tmdb.org/t/p/w500${url}"
    }
}
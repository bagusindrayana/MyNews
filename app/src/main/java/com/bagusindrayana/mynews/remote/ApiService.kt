package com.bagusindrayana.mynews.remote

import com.bagusindrayana.mynews.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/top-headlines?country=id&apiKey=aff15bb2062b4545a98955e51c3956fb")
    fun getNews():Call<NewsResponse>
}
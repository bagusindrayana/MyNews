package com.bagusindrayana.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bagusindrayana.mynews.models.NewsResponse
import com.bagusindrayana.mynews.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()

    }

    fun getNews(){
        Log.d("GET_NEWS","CALL")
        ApiClient.create().getNews().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                Log.d("GET_NEWS_RESPONSE",response.body().toString())
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("GET_NEWS_FAILURE",t.toString())
            }

        })
    }
}
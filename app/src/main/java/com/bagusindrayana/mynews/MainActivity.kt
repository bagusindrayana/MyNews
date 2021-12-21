package com.bagusindrayana.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bagusindrayana.mynews.adapter.NewsAdapter
import com.bagusindrayana.mynews.models.ArticlesItem
import com.bagusindrayana.mynews.models.NewsResponse
import com.bagusindrayana.mynews.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()
        initRvNews()

    }

    private fun initRvNews() {
        val rvNews = findViewById<RecyclerView>(R.id.rvNews)
        adapter = NewsAdapter {

        }
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = adapter
    }


    fun getNews(){
        Log.d("GET_NEWS","CALL")
        ApiClient.create().getNews().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if(response.isSuccessful){
                    val articles : List<ArticlesItem> = response.body()?.articles as List<ArticlesItem>
                    adapter.setNews(articles)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("GET_NEWS_FAILURE",t.toString())
            }

        })
    }
}
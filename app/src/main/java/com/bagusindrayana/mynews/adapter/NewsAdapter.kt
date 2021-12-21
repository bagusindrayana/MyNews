package com.bagusindrayana.mynews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bagusindrayana.mynews.R
import com.bagusindrayana.mynews.models.ArticlesItem

class NewsAdapter(private val listener:(ArticlesItem)->Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var news : List<ArticlesItem> = mutableListOf<ArticlesItem>()

    fun setNews(news: List<ArticlesItem>){
        this.news = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount(): Int {
        return this.news.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        fun bind(news : ArticlesItem){
            itemView.findViewById<TextView>(R.id.judul).text = news.title
            itemView.setOnClickListener {
                listener(news)
            }

        }
    }
}
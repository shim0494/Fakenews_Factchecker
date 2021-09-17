package com.example.fakenews_factchecker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var datas = mutableListOf<NewsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtTitle: TextView = itemView.findViewById(R.id.rv_news_title)
        private val txtResult: TextView = itemView.findViewById(R.id.rv_news_result)
        private val imgEmoji: ImageView = itemView.findViewById(R.id.rv_news_emoji)

        fun bind(item: NewsData) {
            txtTitle.text = item.title
            txtResult.text = item.result
            Glide.with(itemView).load(item.img).into(imgEmoji)

        }
    }


}
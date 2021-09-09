package com.example.fakenewsfiltering

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Keyword_RCView_Adapter(private val context: Context) : RecyclerView.Adapter<Keyword_RCView_Adapter.ViewHolder>() {
    var datas = mutableListOf<KeywordSearch_ResultData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.search_result_itemview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val artTitle_TV : TextView = itemView.findViewById(R.id.rv_item_artTitle)
        private val artContents_TV : TextView = itemView.findViewById(R.id.rv_item_artContents)

        fun bind(item: KeywordSearch_ResultData) {
            artTitle_TV.text = item.naver_title
            artContents_TV.text = item.naver_link
        }
    }
}
package com.minwook.rx_study.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minwook.rx_study.R
import com.minwook.rx_study.network.response.Repositories
import kotlinx.android.synthetic.main.list_item_search.view.*

class SearchListAdapter(val context: Context): RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>() {

    private var list: ArrayList<Repositories> = arrayListOf()

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : Repositories){
            with(itemView) {
                tv_title.text = data.name
                tv_language.text = data.language
                tv_description.text = data.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_search, parent, false)

        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(list: ArrayList<Repositories>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
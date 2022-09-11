package com.example.ilmizlab.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilmizlab.databinding.NewsItemLayoutBinding
import com.example.ilmizlab.models.CoursesModel
import com.example.ilmizlab.models.NewsModel

class NewsAdapter(val items: List<NewsModel>): RecyclerView.Adapter<NewsAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: NewsItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]


    }

    override fun getItemCount(): Int = items.size
}
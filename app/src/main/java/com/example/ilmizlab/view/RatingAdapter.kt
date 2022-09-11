package com.example.ilmizlab.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilmizlab.databinding.PricesItemLayoutBinding
import com.example.ilmizlab.models.RatingModel

class RatingAdapter(val items: List<RatingModel>): RecyclerView.Adapter<RatingAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: PricesItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(PricesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.binding.userName.text = item.user_fullname
        holder.binding.data.text = item.data
        holder.binding.rating.text = item.rating.toDouble().toString()
        holder.binding.userComment.text = item.comment
    }

    override fun getItemCount(): Int = items.size
}
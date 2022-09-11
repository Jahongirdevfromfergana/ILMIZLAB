package com.example.ilmizlab.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ilmizlab.screen.DetailActivity
import com.example.ilmizlab.databinding.TopCenterItemLyoutBinding
import com.example.ilmizlab.models.TrainingCenterModel
import com.example.ilmizlab.utils.Constants

interface TopCenterAdapterCallback{
    fun onClickItem(item: TrainingCenterModel)
}

class TopCenterAdapter(val items: List<TrainingCenterModel>, val callback: TopCenterAdapterCallback): RecyclerView.Adapter<TopCenterAdapter.ItemHolder>() {
    inner  class ItemHolder(val binding: TopCenterItemLyoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(TopCenterItemLyoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClickItem(item)
        }
        holder.binding.tvTopCenterTitle.text = item.name
        holder.binding.tvTopCenterComment.text = item.comment
        holder.binding.monthlyPaymentMax.text = item.monthly_payment_max.toString()
        holder.binding.monthlyPaymentMin.text = item.monthly_payment_min.toString()
        holder.binding.ratingCount.text = item.rating.toDouble().toString()
        holder.binding.tvLocation.text = item.address

        Glide.with(holder.itemView).load(Constants.IMAGE_HOST + item.main_image).into(holder.binding.tvTopImage)
    }
        override fun getItemCount(): Int = items.size

}
package com.example.ilmizlab.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ilmizlab.databinding.CenterItemLayoutBinding
import com.example.ilmizlab.models.TrainingCenterModel
import com.example.ilmizlab.utils.Constants

interface CenterAdapterCallback{
    fun onClickItem(item: TrainingCenterModel)
}

class CenterAdapter(val items: List<TrainingCenterModel>, val callback: CenterAdapterCallback): RecyclerView.Adapter<CenterAdapter.ItemHolder>() {
    inner  class ItemHolder(val binding: CenterItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(CenterItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClickItem(item)
        }
        holder.binding.tvLocation.text = item.address
        holder.binding.tvTitle.text = item.name
        holder.binding.tvComment.text = item.comment
        holder.binding.monthlyPaymentMin.text = item.monthly_payment_min.toString()
        holder.binding.monthlyPaymentMax.text = item.monthly_payment_max.toString()
        holder.binding.ratingCount.text = item.rating.toString().substring(0, 2)

        Glide.with(holder.itemView).load(Constants.IMAGE_HOST + item.main_image).into(holder.binding.mainImage)
    }
    override fun getItemCount(): Int = items.size
}
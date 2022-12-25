package com.example.ilmizlab.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ilmizlab.databinding.ScienceItemLayoutBinding
import com.example.ilmizlab.models.ScienceModel
import com.example.ilmizlab.utils.Constants

class ScienceAdapter(
    val items: List<ScienceModel>
): RecyclerView.Adapter<ScienceAdapter.ItemHolder>(){
    inner class ItemHolder(val binding: ScienceItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ScienceItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.binding.tvScienceName.text = item.title

        Glide.with(holder.itemView.context).load(Constants.IMAGE_HOST + item.icon).into(holder.binding.tvScienceIcon)
    }
    override fun getItemCount(): Int = items.size

}
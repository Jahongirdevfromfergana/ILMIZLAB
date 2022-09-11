package com.example.ilmizlab.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ilmizlab.databinding.CategoryItemBinding
import com.example.ilmizlab.models.CategoryModel
import com.example.ilmizlab.models.ScienceModel
import com.example.ilmizlab.utils.Constants

interface CategoryAdapterCallback{
    fun onClickItem(item: CategoryModel)
}

class CategoryAdapter(
    val items: List<CategoryModel>, val callback: CategoryAdapterCallback
): RecyclerView.Adapter<CategoryAdapter.ItemHolder>(){
    inner class ItemHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClickItem(item)
        }
        holder.binding.tvCategoryName.text = item.title
        Glide.with(holder.itemView.context).load(Constants.IMAGE_HOST + item.icon).into(holder.binding.tvCategoryIcon)
    }

    override fun getItemCount(): Int = items.size

}
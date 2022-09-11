package com.example.ilmizlab.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilmizlab.databinding.CourseItemLayoutBinding
import com.example.ilmizlab.models.CoursesModel
import com.example.ilmizlab.models.TrainingCenterModel

class CourseAdapter(val items: List<CoursesModel>): RecyclerView.Adapter<CourseAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: CourseItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseAdapter.ItemHolder {
        return ItemHolder(CourseItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
           }

    override fun onBindViewHolder(holder: CourseAdapter.ItemHolder, position: Int) {
        val item = items[position]
        holder.binding.courseName.text = item.name
        holder.binding.coursePrice.text = item.monthly_payment.toString()
        holder.binding.btnTeacher.text = item.science?.title

    }

    override fun getItemCount(): Int = items.size
}
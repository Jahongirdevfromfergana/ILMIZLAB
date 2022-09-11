package com.example.ilmizlab.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ilmizlab.R
import com.example.ilmizlab.databinding.ActivityScienseBinding
import com.example.ilmizlab.models.CategoryModel
import com.example.ilmizlab.models.ScienceModel
import com.example.ilmizlab.utils.Constants
import com.example.ilmizlab.view.ScienceAdapter

class ScienceActivity : AppCompatActivity() {
    lateinit var binding: ActivityScienseBinding
    lateinit var item: CategoryModel

    val players = arrayListOf(" Fargona", "Andijon", "Jizzax")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScienseBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        val language = resources.getStringArray(R.string.language.toLong().toInt())
//        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item_layout, language)
//        binding.autoComplete.setAdapter(arrayAdapter)




        binding.tvBack.setOnClickListener {
            finish()
        }
        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as CategoryModel
        binding.scienceName.text = item.title
        binding.recyclerScienceCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerScienceCategories.adapter = ScienceAdapter(item.sciences as List<ScienceModel>)

    }
}
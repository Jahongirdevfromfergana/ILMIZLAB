package com.example.ilmizlab.models

import java.io.Serializable

data class CategoryModel(
    val id: Int,
    val title: String,
    val icon: String,
    val sciences: List<ScienceModel>
): Serializable

data class ScienceModel(
    val id: Int,
    val category_id: Int,
    val title: String,
    val icon: String
): Serializable
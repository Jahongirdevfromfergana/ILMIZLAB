package com.example.ilmizlab.models

import java.io.Serializable

data class NewsModel(
    val int: Int,
    val center_id: Int,
    val title: String,
    val image: String,
    val content: String,
    val status: String,
    val center_image: String,
    val center_name: String,
    val data: String,
    val district_name: String

):Serializable
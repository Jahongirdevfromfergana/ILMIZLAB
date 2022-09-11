package com.example.ilmizlab.models

data class RatingModel(
    val id: Int,
    val user_id: Int,
    val rating: Int,
    val comment: String,
    val data: String,
    val user_fullname: String,
    val user_avatar: String
)
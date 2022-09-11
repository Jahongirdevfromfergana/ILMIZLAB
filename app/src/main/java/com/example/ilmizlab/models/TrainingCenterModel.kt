package com.example.ilmizlab.models

import java.io.Serializable

data class TrainingCenterModel(
    val id: Int,
    val region_id: Int,
    val district_id: Int,
    val name: String,
    val phone: String,
    val address: String,
    val comment: String,
    val monthly_payment_min: Int,
    val monthly_payment_max: Int,
    val main_image: String,
    val latitude: Double,
    val longitude: Double,
    val rating: Double,
    val rating_count: Int,
    val images: List<String>,
    val subsribers_count: Int,
    val district: District,
    val region: Region,
    val courses: List<CoursesModel>

): Serializable

data class District(
    val id: Int,
    val region_id: Int,
    val district_name: String,

): Serializable
data class Region(
    val id: Int,
    val region_mane: String

): Serializable

data class CoursesModel(
    val id: Int,
    val center_id: Int,
    val science_id: Int,
    val name: String,
    val monthly_payment: Int,
    val created_at: String,
    val updated_at: Int,
    val science: Science? = null

): Serializable

data class Science(
    val id: Int,
    val category_id: Int,
    val title: String,
    val icon: String,
    val created_at: String

):Serializable


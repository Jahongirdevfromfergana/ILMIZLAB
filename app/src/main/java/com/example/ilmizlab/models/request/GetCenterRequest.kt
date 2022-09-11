package com.example.ilmizlab.models.request


data class GetCenterRequest(
    val region_id: Int,
    val district_id: Int,
    val category_id: Int,
    val science_id: Int,
    val keyword: String,
    val sort: String,
    val limit: Int,
    val latitude: Double,
    val longitude: Double
)
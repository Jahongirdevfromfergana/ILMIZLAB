package com.example.ilmizlab.models

import java.io.Serializable

data class AddressModel(
    val address: String,
    val latitude: Double,
    val longitude: Double
    ):Serializable
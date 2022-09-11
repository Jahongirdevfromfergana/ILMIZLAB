package com.example.ilmizlab.models

import java.io.Serializable

data class BaseResponseModel<T>(
    val success: Boolean,
    val data: T,
    val message: String,
    val error_code: Int
): Serializable
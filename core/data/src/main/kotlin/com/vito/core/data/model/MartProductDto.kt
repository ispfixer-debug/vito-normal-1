package com.vito.core.data.model

data class MartProductDto(
    val id: String = "",
    val name: String = "",
    val description: String? = null,
    val price: Double = 0.0,
    val imageUrl: String? = null,
    val category: String = "",
    val inStock: Boolean = true,
    val stockQuantity: Int = 0
)

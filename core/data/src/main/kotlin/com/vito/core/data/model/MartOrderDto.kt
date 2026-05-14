package com.vito.core.data.model

data class MartOrderDto(
    val id: String = "",
    val userId: String = "",
    val products: List<MartOrderItemDto> = emptyList(),
    val totalPrice: Double = 0.0,
    val status: String = "PENDING",
    val deliveryAddress: String = "",
    val createdAt: Long? = null,
    val deliveredAt: Long? = null
)

data class MartOrderItemDto(
    val productId: String = "",
    val productName: String = "",
    val quantity: Int = 0,
    val price: Double = 0.0
)

package com.vito.core.data.model

data class PackageDto(
    val id: String = "",
    val senderId: String = "",
    val senderName: String = "",
    val senderPhone: String = "",
    val receiverName: String = "",
    val receiverPhone: String = "",
    val receiverAddress: String = "",
    val weight: Double = 0.0,
    val description: String? = null,
    val signatureRequired: Boolean = false,
    val status: String = "PENDING",
    val price: Double = 0.0,
    val createdAt: Long? = null,
    val deliveredAt: Long? = null,
    val driverId: String? = null,
    val driverName: String? = null
)

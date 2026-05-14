package com.vito.core.data.model

data class RideDto(
    val id: String = "",
    val clientId: String = "",
    val driverId: String? = null,
    val status: String = "PENDING",
    val pickupLatitude: Double? = null,
    val pickupLongitude: Double? = null,
    val pickupAddress: String = "",
    val dropoffLatitude: Double? = null,
    val dropoffLongitude: Double? = null,
    val dropoffAddress: String = "",
    val stops: List<StopDto> = emptyList(),
    val vehicleType: String = "STANDARD",
    val estimatedPrice: Double = 0.0,
    val finalPrice: Double = 0.0,
    val distance: Double = 0.0,
    val duration: Long = 0,
    val createdAt: Long? = null,
    val acceptedAt: Long? = null,
    val arrivedAt: Long? = null,
    val startedAt: Long? = null,
    val completedAt: Long? = null,
    val rating: Int? = null,
    val tip: Double = 0.0,
    val promoCode: String? = null,
    val driverName: String? = null,
    val driverPhone: String? = null,
    val driverPhotoUrl: String? = null,
    val vehiclePlate: String? = null
)

data class StopDto(
    val latitude: Double? = null,
    val longitude: Double? = null,
    val address: String = "",
    val order: Int = 0
)

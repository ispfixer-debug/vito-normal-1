package com.vito.core.data.model

data class UserDto(
    val uid: String = "",
    val email: String? = null,
    val phoneNumber: String? = null,
    val displayName: String? = null,
    val role: String = "CLIENT",
    val alias: String? = null,
    val photoUrl: String? = null,
    val isActive: Boolean = true,
    val createdAt: Long? = null,
    val lastLoginAt: Long? = null,
    val walletBalance: Double = 0.0,
    val rating: Double = 0.0,
    val totalRides: Int = 0
)

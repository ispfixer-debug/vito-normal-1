package com.vito.core.data.model

data class QrTokenDto(
    val id: String = "",
    val token: String = "",
    val userId: String = "",
    val role: String = "CLIENT",
    val alias: String? = null,
    val isActive: Boolean = true,
    val createdAt: Long? = null,
    val expiresAt: Long? = null,
    val usedAt: Long? = null,
    val usedBy: String? = null
)

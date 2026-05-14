package com.vito.core.data.repository

import com.vito.core.data.model.QrTokenDto
import kotlinx.coroutines.flow.Flow

interface QrRepository {
    fun getQrToken(token: String): Flow<QrTokenDto?>
    fun getUserQrs(userId: String): Flow<List<QrTokenDto>>
    
    suspend fun generateQr(userId: String, role: String): Result<QrTokenDto>
    suspend fun validateQr(token: String): Result<QrTokenDto>
    suspend fun deactivateQr(tokenId: String): Result<Unit>
}

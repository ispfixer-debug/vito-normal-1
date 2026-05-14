package com.vito.core.data.repository.impl

import com.vito.core.data.model.QrTokenDto
import com.vito.core.data.repository.QrRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QrRepositoryImpl @Inject constructor() : QrRepository {

    private val _qr = MutableStateFlow<QrTokenDto?>(null)

    override fun getQrToken(token: String): Flow<QrTokenDto?> = _qr.asStateFlow()

    override fun getUserQrs(userId: String): Flow<List<QrTokenDto>> = MutableStateFlow(emptyList())

    override suspend fun generateQr(userId: String, role: String): Result<QrTokenDto> = Result.success(
        QrTokenDto(token = "DEMO-${System.currentTimeMillis()}", userId = userId, role = role)
    )

    override suspend fun validateQr(token: String): Result<QrTokenDto> = Result.success(
        QrTokenDto(token = token, userId = "demo", role = "CLIENT", isActive = true)
    )

    override suspend fun deactivateQr(tokenId: String): Result<Unit> = Result.success(Unit)
}

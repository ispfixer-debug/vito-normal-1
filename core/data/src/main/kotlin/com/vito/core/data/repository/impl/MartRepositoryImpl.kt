package com.vito.core.data.repository.impl

import com.vito.core.data.model.MartProductDto
import com.vito.core.data.model.MartOrderDto
import com.vito.core.data.repository.MartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MartRepositoryImpl @Inject constructor() : MartRepository {

    private val _products = MutableStateFlow<List<MartProductDto>>(emptyList())

    override fun getProducts(): Flow<List<MartProductDto>> = _products.asStateFlow()

    override fun getProductById(productId: String): Flow<MartProductDto?> = MutableStateFlow(null)

    override fun getUserOrders(userId: String): Flow<List<MartOrderDto>> = MutableStateFlow(emptyList())

    override fun getActiveOrder(userId: String): Flow<MartOrderDto?> = MutableStateFlow(null)

    override suspend fun createOrder(order: MartOrderDto): Result<MartOrderDto> = Result.success(order)

    override suspend fun updateOrderStatus(orderId: String, status: String): Result<Unit> = Result.success(Unit)
}

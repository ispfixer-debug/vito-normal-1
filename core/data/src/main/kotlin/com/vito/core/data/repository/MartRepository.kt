package com.vito.core.data.repository

import com.vito.core.data.model.MartProductDto
import com.vito.core.data.model.MartOrderDto
import kotlinx.coroutines.flow.Flow

interface MartRepository {
    fun getProducts(): Flow<List<MartProductDto>>
    fun getProductById(productId: String): Flow<MartProductDto?>
    fun getUserOrders(userId: String): Flow<List<MartOrderDto>>
    fun getActiveOrder(userId: String): Flow<MartOrderDto?>
    
    suspend fun createOrder(order: MartOrderDto): Result<MartOrderDto>
    suspend fun updateOrderStatus(orderId: String, status: String): Result<Unit>
}

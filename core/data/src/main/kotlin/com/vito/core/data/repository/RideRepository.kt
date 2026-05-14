package com.vito.core.data.repository

import com.vito.core.data.model.RideDto
import kotlinx.coroutines.flow.Flow

interface RideRepository {
    fun getActiveRide(clientId: String): Flow<RideDto?>
    fun getRideById(rideId: String): Flow<RideDto?>
    fun getNearbyDrivers(latitude: Double, longitude: Double, radiusKm: Double): Flow<List<RideDto>>
    
    suspend fun requestRide(ride: RideDto): Result<RideDto>
    suspend fun cancelRide(rideId: String): Result<Unit>
    suspend fun acceptRide(rideId: String, driverId: String): Result<Unit>
    suspend fun startRide(rideId: String): Result<Unit>
    suspend fun completeRide(rideId: String): Result<Unit>
    suspend fun rateRide(rideId: String, rating: Int): Result<Unit>
}

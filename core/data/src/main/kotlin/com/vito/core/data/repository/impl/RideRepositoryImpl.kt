package com.vito.core.data.repository.impl

import com.vito.core.data.model.RideDto
import com.vito.core.data.repository.RideRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RideRepositoryImpl @Inject constructor() : RideRepository {
    private val _ride = MutableStateFlow<RideDto?>(null)

    override fun getActiveRide(clientId: String): Flow<RideDto?> = _ride.asStateFlow()
    override fun getRideById(rideId: String): Flow<RideDto?> = _ride.asStateFlow()
    override fun getNearbyDrivers(latitude: Double, longitude: Double, radiusKm: Double): Flow<List<RideDto>> = MutableStateFlow(emptyList())

    override suspend fun requestRide(ride: RideDto): Result<RideDto> = Result.success(ride)
    override suspend fun cancelRide(rideId: String): Result<Unit> = Result.success(Unit)
    override suspend fun acceptRide(rideId: String, driverId: String): Result<Unit> = Result.success(Unit)
    override suspend fun startRide(rideId: String): Result<Unit> = Result.success(Unit)
    override suspend fun completeRide(rideId: String): Result<Unit> = Result.success(Unit)
    override suspend fun rateRide(rideId: String, rating: Int): Result<Unit> = Result.success(Unit)
}

package com.vito.core.data.repository

import com.vito.core.data.model.PackageDto
import kotlinx.coroutines.flow.Flow

interface PackageRepository {
    fun getActivePackage(userId: String): Flow<PackageDto?>
    fun getPackageById(packageId: String): Flow<PackageDto?>
    fun getUserPackages(userId: String): Flow<List<PackageDto>>
    
    suspend fun sendPackage(pkg: PackageDto): Result<PackageDto>
    suspend fun cancelPackage(packageId: String): Result<Unit>
    suspend fun updatePackageStatus(packageId: String, status: String): Result<Unit>
}

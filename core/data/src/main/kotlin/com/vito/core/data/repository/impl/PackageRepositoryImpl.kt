package com.vito.core.data.repository.impl

import com.vito.core.data.model.PackageDto
import com.vito.core.data.repository.PackageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PackageRepositoryImpl @Inject constructor() : PackageRepository {
    private val _packages = MutableStateFlow<PackageDto?>(null)

    override fun getActivePackage(userId: String): Flow<PackageDto?> = _packages.asStateFlow()
    override fun getPackageById(packageId: String): Flow<PackageDto?> = _packages.asStateFlow()
    override fun getUserPackages(userId: String): Flow<List<PackageDto>> = MutableStateFlow(emptyList())

    override suspend fun sendPackage(pkg: PackageDto): Result<PackageDto> = Result.success(pkg)
    override suspend fun cancelPackage(packageId: String): Result<Unit> = Result.success(Unit)
    override suspend fun updatePackageStatus(packageId: String, status: String): Result<Unit> = Result.success(Unit)
}

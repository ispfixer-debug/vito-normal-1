package com.vito.core.data.repository

import com.vito.core.data.model.UserDto
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserById(uid: String): Flow<UserDto?>
    fun searchUsers(query: String): Flow<List<UserDto>>
    fun getAllDrivers(): Flow<List<UserDto>>
    
    suspend fun createUser(user: UserDto): Result<UserDto>
    suspend fun updateUser(user: UserDto): Result<Unit>
    suspend fun updateUserRole(uid: String, role: String): Result<Unit>
    suspend fun toggleUserActive(uid: String, isActive: Boolean): Result<Unit>
}

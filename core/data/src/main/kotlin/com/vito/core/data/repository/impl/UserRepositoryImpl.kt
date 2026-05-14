package com.vito.core.data.repository.impl

import com.vito.core.data.model.UserDto
import com.vito.core.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {

    private val _user = MutableStateFlow<UserDto?>(null)

    override fun getUserById(uid: String): Flow<UserDto?> = _user.asStateFlow()

    override fun searchUsers(query: String): Flow<List<UserDto>> = MutableStateFlow(emptyList())

    override fun getAllDrivers(): Flow<List<UserDto>> = MutableStateFlow(emptyList())

    override suspend fun createUser(user: UserDto): Result<UserDto> = Result.success(user)

    override suspend fun updateUser(user: UserDto): Result<Unit> = Result.success(Unit)

    override suspend fun updateUserRole(uid: String, role: String): Result<Unit> = Result.success(Unit)

    override suspend fun toggleUserActive(uid: String, isActive: Boolean): Result<Unit> = Result.success(Unit)
}

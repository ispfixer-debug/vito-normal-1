package com.vito.core.data.repository.impl

import com.vito.core.data.model.UserDto
import com.vito.core.data.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    
    private val _currentUser = MutableStateFlow<UserDto?>(null)
    override val currentUser: Flow<UserDto?> = _currentUser.asStateFlow()
    
    override val isAuthenticated: Flow<Boolean> = _currentUser.map { it != null }

    override suspend fun signInWithCustomToken(token: String): Result<UserDto> {
        val user = UserDto(uid = "demo-user", displayName = "Demo User", role = "CLIENT")
        _currentUser.value = user
        return Result.success(user)
    }

    override suspend fun signOut() {
        _currentUser.value = null
    }

    override suspend fun getCurrentUser(): UserDto? = _currentUser.value

    override suspend fun updateUserProfile(user: UserDto): Result<Unit> {
        _currentUser.value = user
        return Result.success(Unit)
    }
}

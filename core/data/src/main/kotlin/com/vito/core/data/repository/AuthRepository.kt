package com.vito.core.data.repository

import com.vito.core.data.model.UserDto
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: Flow<UserDto?>
    val isAuthenticated: Flow<Boolean>
    
    suspend fun signInWithCustomToken(token: String): Result<UserDto>
    suspend fun signOut()
    suspend fun getCurrentUser(): UserDto?
    suspend fun updateUserProfile(user: UserDto): Result<Unit>
}

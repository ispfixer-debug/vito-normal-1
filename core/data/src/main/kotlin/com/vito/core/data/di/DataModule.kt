package com.vito.core.data.di

import com.vito.core.data.repository.*
import com.vito.core.data.repository.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
    
    @Binds
    @Singleton
    abstract fun bindRideRepository(impl: RideRepositoryImpl): RideRepository
    
    @Binds
    @Singleton
    abstract fun bindPackageRepository(impl: PackageRepositoryImpl): PackageRepository
    
    @Binds
    @Singleton
    abstract fun bindMartRepository(impl: MartRepositoryImpl): MartRepository
    
    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
    
    @Binds
    @Singleton
    abstract fun bindQrRepository(impl: QrRepositoryImpl): QrRepository
}

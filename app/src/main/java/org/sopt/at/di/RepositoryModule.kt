package org.sopt.at.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.repositoryImpl.UserRepositoryImpl
import org.sopt.at.data.service.UserService
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userService: UserService): UserRepository = UserRepositoryImpl(userService)
}
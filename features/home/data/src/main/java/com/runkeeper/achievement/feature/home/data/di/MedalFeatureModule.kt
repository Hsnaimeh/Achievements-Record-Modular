package com.runkeeper.achievement.feature.home.data.di

import com.runkeeper.achievement.feature.home.data.AchievementRepositoryImpl
import com.runkeeper.achievement.feature.home.domain.repository.AchievementRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface MedalFeatureModule {

    @Binds
    fun bindHomeRepository(impl: AchievementRepositoryImpl): AchievementRepository

}

package com.runkeeper.achievement.feature.home.data.di

import com.runkeeper.achievement.feature.home.data.remote.AchievementRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
internal object MedalRemoteModule {


    @Provides
    fun provideMedalRemoteDataSource(retrofit: Retrofit): AchievementRemoteDataSource {
        return retrofit.create()
    }

}

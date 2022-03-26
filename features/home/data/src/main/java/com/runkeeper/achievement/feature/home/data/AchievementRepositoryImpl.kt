package com.runkeeper.achievement.feature.home.data

import com.runkeeper.achievement.feature.home.data.mapper.AchievementMapper
import com.runkeeper.achievement.feature.home.data.remote.AchievementRemoteDataSource
import com.runkeeper.achievement.feature.home.domain.repository.AchievementRepository
import com.runkeeper.achievement.feature.home.domain.model.AchievementModel
import javax.inject.Inject

internal class AchievementRepositoryImpl @Inject constructor(
    private val achievementRemoteDataSource: AchievementRemoteDataSource,
    private val achievementMapper: AchievementMapper,
) : AchievementRepository {

    override suspend fun getAchievements(): List<AchievementModel> {
        return achievementMapper.mapList(achievementRemoteDataSource.getMadel())
    }
}

package com.runkeeper.achievement.feature.home.domain.repository

import com.runkeeper.achievement.feature.home.domain.model.AchievementModel

interface AchievementRepository {

    suspend fun getAchievements(): List<AchievementModel>

}
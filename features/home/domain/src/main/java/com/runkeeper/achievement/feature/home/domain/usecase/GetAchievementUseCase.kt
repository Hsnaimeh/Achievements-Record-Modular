package com.runkeeper.achievement.feature.home.domain.usecase

import com.runkeeper.achievement.feature.home.domain.model.AchievementModel
import com.runkeeper.achievement.feature.home.domain.repository.AchievementRepository
import javax.inject.Inject

class GetAchievementUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
) {
    suspend operator fun invoke(): List<AchievementModel> {
        return achievementRepository.getAchievements()
    }
}
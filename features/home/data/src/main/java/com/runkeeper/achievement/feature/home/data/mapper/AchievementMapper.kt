package com.runkeeper.achievement.feature.home.data.mapper

import com.runkeeper.achievement.feature.home.data.remote.model.RemoteAchievementResponse
import com.runkeeper.achievement.feature.home.data.remote.model.RemoteRecordsResponse
import com.runkeeper.achievement.feature.home.domain.model.RecordsModel
import com.runkeeper.achievement.feature.home.domain.model.AchievementModel
import javax.inject.Inject

internal class AchievementMapper @Inject constructor():
    com.runkeeper.achievement.core.data.Mapper<RemoteAchievementResponse, AchievementModel> {

    override fun map(source: RemoteAchievementResponse): AchievementModel {
        return AchievementModel(
            id = source.id,
            title = source.title,
            label = source.label,
            records = source.records.map { mapRecords(it) },
        )
    }

    private fun mapRecords(remoteRecordsResponse: RemoteRecordsResponse): RecordsModel {
        return RecordsModel(
            id = remoteRecordsResponse.id,
            title = remoteRecordsResponse.title,
            label = remoteRecordsResponse.label,
            active = remoteRecordsResponse.active,
            image = remoteRecordsResponse.image
        )
    }

}
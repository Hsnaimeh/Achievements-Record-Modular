package com.runkeeper.achievement.feature.home.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class RemoteAchievementResponse(

    @Json(name = "id")
    var id: Int,

    @Json(name = "title")
    var title: String,

    @Json(name = "label")
    var label: String,

    @Json(name = "records")
    var records: List<RemoteRecordsResponse>,
)
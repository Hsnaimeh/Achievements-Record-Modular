package com.runkeeper.achievement.feature.home.data.remote

import com.runkeeper.achievement.feature.home.data.remote.model.RemoteAchievementResponse
import com.serjltt.moshi.adapters.Wrapped
import retrofit2.http.GET

internal interface AchievementRemoteDataSource{

    @GET("/achievements")
    @Wrapped(path = ["data"])
    suspend fun getMadel(): List<RemoteAchievementResponse>

}
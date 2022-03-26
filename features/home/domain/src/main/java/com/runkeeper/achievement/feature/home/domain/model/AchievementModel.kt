package com.runkeeper.achievement.feature.home.domain.model


data class AchievementModel(

    val id: Int,

    val title: String,

    val label: String,

    val records: List<RecordsModel>,

    )

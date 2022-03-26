package com.runkeeper.achievement.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runkeeper.achievement.feature.home.domain.usecase.GetAchievementUseCase
import com.runkeeper.achievement.feature.home.domain.model.AchievementModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAchievementUseCase: GetAchievementUseCase) :
    ViewModel() {

    private var _loadingStateFlow = MutableStateFlow(false)
    var loadingStateFlow: MutableStateFlow<Boolean> = _loadingStateFlow

    private var _errorStateFlow = MutableStateFlow<String?>(null)
    var errorStateFlow: StateFlow<String?> = _errorStateFlow

    private var _successMedalStateFlow = MutableStateFlow<List<AchievementModel>?>(null)
    var successAchievementStateFlow: StateFlow<List<AchievementModel>?> = _successMedalStateFlow

    init {
        getAchievements()
    }

    private fun getAchievements() {
        viewModelScope.launch {
            _loadingStateFlow.emit(true)
            try {
                _successMedalStateFlow.emit(getAchievementUseCase())
            } catch (e: Exception) {
                _errorStateFlow.emit(e.message)
            }
            _loadingStateFlow.emit(false)
        }
    }
}
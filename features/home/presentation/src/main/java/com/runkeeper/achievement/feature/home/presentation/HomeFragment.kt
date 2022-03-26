package com.runkeeper.achievement.feature.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.runkeeper.achievement.feature.home.presentation.adapter.SectionAchievementAdapter
import com.runkeeper.achievement.feature.home.presentation.databinding.FragmentAchievementBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val achievementViewModel: HomeViewModel by viewModels()

    lateinit var binding: FragmentAchievementBinding

    private lateinit var sectionAchievementAdapter: SectionAchievementAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAchievementBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initObservers()
    }

    private fun initObservers() {

        handleProgress()
        handleError()
        successAchievement()
    }


    private fun successAchievement() {
        lifecycleScope.launch {
            achievementViewModel.successAchievementStateFlow.collect {
                sectionAchievementAdapter.submitList(it)
            }
        }
    }

    private fun init() {
        initAdapter()
    }

    private fun initAdapter() {
        sectionAchievementAdapter = SectionAchievementAdapter()
        binding.recyclerViewMedal.adapter = sectionAchievementAdapter
    }

    private fun handleProgress() {
        lifecycleScope.launch {
            achievementViewModel.loadingStateFlow.collect { isShow ->
                binding.progressBar.isVisible = isShow
            }
        }
    }

    private fun handleError() {
        lifecycleScope.launch {
            achievementViewModel.errorStateFlow.collect { errorMessage ->
                if (!errorMessage.isNullOrEmpty())
                    Toast.makeText(context, errorMessage.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

}
package com.runkeeper.achievement.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.runkeeper.achievement.feature.home.presentation.databinding.RowSectionAchievementBinding
import com.runkeeper.achievement.feature.home.domain.model.AchievementModel

class SectionAchievementAdapter :
    ListAdapter<AchievementModel, SectionAchievementAdapter.MedalViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MedalViewHolder {
        val binding =
            RowSectionAchievementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class MedalViewHolder(private val binding: RowSectionAchievementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val medalAdapter = MedalAdapter()

        fun bind(model: AchievementModel) {
            binding.model = model
            binding.executePendingBindings()

            medalAdapter.submitList(model.records)

            binding.recyclerViewMedal.adapter = medalAdapter
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<AchievementModel>() {

        override fun areItemsTheSame(oldItem: AchievementModel, newItem: AchievementModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AchievementModel, newItem: AchievementModel) =
            oldItem == newItem

    }
}
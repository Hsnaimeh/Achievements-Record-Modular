package com.runkeeper.achievement.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.runkeeper.achievement.feature.home.domain.model.RecordsModel
import com.runkeeper.achievement.feature.home.presentation.databinding.RowMedalBinding


class MedalAdapter : ListAdapter<RecordsModel, MedalAdapter.MedalViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val binding =
            RowMedalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MedalViewHolder(private val binding: RowMedalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecordsModel) {
            binding.model = item
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<RecordsModel>() {

        override fun areItemsTheSame(oldItem: RecordsModel, newItem: RecordsModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecordsModel, newItem: RecordsModel) =
            oldItem == newItem

    }
}
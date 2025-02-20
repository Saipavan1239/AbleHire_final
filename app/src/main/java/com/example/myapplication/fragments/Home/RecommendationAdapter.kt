package com.example.myapplication.fragments.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.RecommendationEachItemBinding

class RecommendationsAdapter : ListAdapter<JobRecommendation, RecommendationsAdapter.RecommendationViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val binding = RecommendationEachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecommendationViewHolder(private val binding: RecommendationEachItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recommendation: JobRecommendation) {
            binding.apply {
                // Load company logo using an image loading library like Glide or Picasso
                Glide.with(logo.context)
                    .load(recommendation.companyLogoUrl)
                    .into(logo)
                typreOfJob.text = recommendation.jobType
                designation.text = recommendation.designation
                company.text = recommendation.companyName
                location.text = recommendation.location
                salary.text = recommendation.salary
                rating.text = recommendation.rating.toString()
                // Set other views accordingly
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<JobRecommendation>() {
        override fun areItemsTheSame(oldItem: JobRecommendation, newItem: JobRecommendation): Boolean {
            // Implement your logic to check if items are the same
            return oldItem.designation == newItem.designation && oldItem.companyName == newItem.companyName
        }

        override fun areContentsTheSame(oldItem: JobRecommendation, newItem: JobRecommendation): Boolean {
            // Implement your logic to check if contents are the same
            return oldItem == newItem
        }
    }
}
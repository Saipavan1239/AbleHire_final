package com.example.myapplication.fragments.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CoursesEachItemBinding

class CoursesAdapter : RecyclerView.Adapter<CoursesAdapter.CarouselViewHolder>() {
    private var imageList: List<Int> = emptyList()

    fun submitList(newList: List<Int>) {
        imageList = newList
        notifyDataSetChanged()
    }

    inner class CarouselViewHolder(private val binding: CoursesEachItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Int) {
            binding.coursesImage.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val binding = CoursesEachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarouselViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(imageList[position])
    }
}
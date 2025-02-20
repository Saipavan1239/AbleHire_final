package com.example.myapplication.fragments.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

class CoursesViewModel : ViewModel() {
    private val _images = MutableLiveData<List<Int>>()
    val images: LiveData<List<Int>> get() = _images

    init {
        loadImages()
    }

    private fun loadImages() {
        _images.value = listOf(
            R.drawable.course1,
            R.drawable.course2,
            R.drawable.course3
        )
    }
}
package com.example.myapplication.fragments.Home

data class JobRecommendation(
    val companyLogoUrl: String,
    val jobType: String,
    val designation: String,
    val companyName: String,
    val location: String,
    val salary: String,
    val rating: Double
)

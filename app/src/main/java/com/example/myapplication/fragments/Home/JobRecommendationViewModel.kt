package com.example.myapplication.fragments.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecommendationsViewModel : ViewModel() {
    private val _recommendations = MutableLiveData<List<JobRecommendation>>()
    val recommendations: LiveData<List<JobRecommendation>> = _recommendations

    init {
        _recommendations.value = listOf(
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "UI/UX Designer",
                companyName = "Infosys",
                location = "Pune",
                salary = "$1500/Monthly",
                rating = 4.3
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "PARTTIME",
                designation = "Software Engineer",
                companyName = "Amazon",
                location = "Hyderabad",
                salary = "$2000/Monthly",
                rating = 4.7
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "Hardware Engineer",
                companyName = "Micron",
                location = "Hyderabad",
                salary = "$3000/Monthly",
                rating = 4.1
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "Software Engineer",
                companyName = "Netflix",
                location = "Hyderabad",
                salary = "$2040/Monthly",
                rating = 4.2
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "CONTRACT",
                designation = "Data Analyst",
                companyName = "Google",
                location = "Bangalore",
                salary = "$2500/Monthly",
                rating = 4.5
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "Cyber Security Analyst",
                companyName = "Cisco",
                location = "Chennai",
                salary = "$2700/Monthly",
                rating = 4.6
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "PARTTIME",
                designation = "Backend Developer",
                companyName = "Meta",
                location = "Remote",
                salary = "$2300/Monthly",
                rating = 4.8
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "Front-end Developer",
                companyName = "Adobe",
                location = "Mumbai",
                salary = "$2200/Monthly",
                rating = 4.4
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "INTERNSHIP",
                designation = "Software Intern",
                companyName = "Tesla",
                location = "Pune",
                salary = "$1000/Monthly",
                rating = 4.2
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "Cloud Engineer",
                companyName = "Microsoft",
                location = "Hyderabad",
                salary = "$2800/Monthly",
                rating = 4.7
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "AI Engineer",
                companyName = "OpenAI",
                location = "Remote",
                salary = "$3500/Monthly",
                rating = 4.9
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "DevOps Engineer",
                companyName = "IBM",
                location = "Bangalore",
                salary = "$2600/Monthly",
                rating = 4.3
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "INTERNSHIP",
                designation = "Mobile App Developer Intern",
                companyName = "Zomato",
                location = "Gurgaon",
                salary = "$1200/Monthly",
                rating = 4.1
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "FULLTIME",
                designation = "Product Manager",
                companyName = "Swiggy",
                location = "Bangalore",
                salary = "$3200/Monthly",
                rating = 4.5
            ),
            JobRecommendation(
                companyLogoUrl = "https://picsum.photos/200/300",
                jobType = "PARTTIME",
                designation = "Graphic Designer",
                companyName = "Canva",
                location = "Remote",
                salary = "$1800/Monthly",
                rating = 4.6
            )
        )
    }
}
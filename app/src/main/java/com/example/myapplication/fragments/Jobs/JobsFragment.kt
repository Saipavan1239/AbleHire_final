package com.example.myapplication.fragments.Jobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class JobsFragment : Fragment() {

    private lateinit var popularJobsRecyclerView: RecyclerView
    private lateinit var allJobsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_jobs, container, false)

        // Initialize RecyclerViews
        popularJobsRecyclerView = view.findViewById(R.id.popular_jobs_rv)
        allJobsRecyclerView = view.findViewById(R.id.all_jobs_rv)

        // Set layout managers
        popularJobsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        allJobsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Provide hardcoded data
        val popularJobs = getPopularJobs()
        val allJobs = getAllJobs()

        // Set adapters
        popularJobsRecyclerView.adapter = JobAdapter(popularJobs)
        allJobsRecyclerView.adapter = JobAdapter(allJobs)

        return view
    }

    private fun getPopularJobs(): List<Job> {
        return listOf(
            Job("Software Engineer", "Google", "Mountain View, CA", "$120,000 - $150,000", R.drawable.login_logo),
            Job("Product Manager", "Facebook", "Menlo Park, CA", "$130,000 - $160,000", R.drawable.login_logo),
            Job("Data Scientist", "Amazon", "Seattle, WA", "$110,000 - $140,000", R.drawable.logo),
            Job("UX Designer", "Apple", "Cupertino, CA", "$100,000 - $130,000", R.drawable.ablehirelogo),
            Job("DevOps Engineer", "Microsoft", "Redmond, WA", "$115,000 - $145,000", R.drawable.logo)
        )
    }

    private fun getAllJobs(): List<Job> {
        return listOf(
            Job("Frontend Developer", "Netflix", "Los Gatos, CA", "$120,000 - $150,000", R.drawable.logo),
            Job("Backend Developer", "Twitter", "San Francisco, CA", "$110,000 - $140,000", R.drawable.login_logo),
            Job("Mobile Developer", "Uber", "San Francisco, CA", "$115,000 - $145,000", R.drawable.login_logo),
            Job("Machine Learning Engineer", "Tesla", "Palo Alto, CA", "$130,000 - $160,000", R.drawable.logo),
            Job("Cloud Architect", "IBM", "Armonk, NY", "$125,000 - $155,000", R.drawable.login_logo)
        )
    }
}
package com.example.myapplication.fragments.Post

import SpinnerViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R


class postFragment : Fragment() {
    private lateinit var spinnerViewModel: SpinnerViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        // Initialize ViewModel
        spinnerViewModel = ViewModelProvider(this).get(SpinnerViewModel::class.java)

        // Initialize Spinners
        val jobRegionSpinner: Spinner = view.findViewById(R.id.job_region_spinner)
        val jobTypeSpinner: Spinner = view.findViewById(R.id.job_type_spinner)
        val jobCategorySpinner: Spinner = view.findViewById(R.id.job_category_spinner)

        // Observe Job Regions
        spinnerViewModel.jobRegions.observe(viewLifecycleOwner) { regions ->
            val adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, regions)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            jobRegionSpinner.adapter = adapter
        }

        // Observe Job Types
        spinnerViewModel.jobTypes.observe(viewLifecycleOwner) { types ->
            val adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, types)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            jobTypeSpinner.adapter = adapter
        }

        // Observe Job Categories
        spinnerViewModel.jobCategories.observe(viewLifecycleOwner) { categories ->
            val adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            jobCategorySpinner.adapter = adapter
        }

        return view
    }


}


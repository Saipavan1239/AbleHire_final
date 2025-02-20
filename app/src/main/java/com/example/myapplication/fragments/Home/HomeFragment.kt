package com.example.myapplication.fragments.Home



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val coursesViewModel: CoursesViewModel by viewModels()
    private val recommendationsViewModel: RecommendationsViewModel by viewModels()
    private lateinit var coursesAdapter: CoursesAdapter
    private lateinit var recommendationsAdapter: RecommendationsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coursesAdapter = CoursesAdapter()
        binding.coursesRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.coursesRv.adapter = coursesAdapter

        // Observe LiveData from CoursesViewModel
        coursesViewModel.images.observe(viewLifecycleOwner) { images ->
            coursesAdapter.submitList(images)
        }

        // Set up Recommendations RecyclerView
        recommendationsAdapter = RecommendationsAdapter()
        binding.recommendationRv.layoutManager = LinearLayoutManager(requireContext())
        binding.recommendationRv.adapter = recommendationsAdapter

        // Observe LiveData from RecommendationsViewModel
        recommendationsViewModel.recommendations.observe(viewLifecycleOwner) { recommendations ->
            recommendationsAdapter.submitList(recommendations)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
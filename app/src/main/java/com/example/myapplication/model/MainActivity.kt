package com.example.myapplication.model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.Community.CommunityFragment
import com.example.myapplication.fragments.Home.HomeFragment
import com.example.myapplication.fragments.Jobs.JobsFragment
import com.example.myapplication.fragments.Post.postFragment
import com.example.myapplication.fragments.Profile.profileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView

        // Load the default fragment (HomeFragment)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Handle Bottom Navigation Item Clicks
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_jobs -> {
                    replaceFragment(JobsFragment())
                    true
                }
                R.id.navigation_post -> {
                    replaceFragment(postFragment())
                    true
                }
                R.id.navigation_community -> {
                    replaceFragment(CommunityFragment())
                    true
                }
                R.id.navigation_profile -> {
                    replaceFragment(profileFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Function to replace fragments manually
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}
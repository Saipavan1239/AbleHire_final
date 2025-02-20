package com.example.myapplication.fragments.Jobs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


data class Job(
    val title: String,
    val company: String,
    val location: String,
    val salary: String,
    val logo: Int // Assuming you have drawable resources for logos
)
class JobAdapter(private val jobList: List<Job>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_jobs_each_item, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.bind(job)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.job_title)
        private val companyTextView: TextView = itemView.findViewById(R.id.company)
        private val locationTextView: TextView = itemView.findViewById(R.id.job_location)
        private val salaryTextView: TextView = itemView.findViewById(R.id.salary)

        fun bind(job: Job) {
            titleTextView.text = job.title
            companyTextView.text = job.company
            locationTextView.text = job.location
            salaryTextView.text = job.salary
        }
    }
}
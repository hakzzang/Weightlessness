package hbs.com.weightlessness.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import hbs.com.weightlessness.databinding.ItemJobcafeListBinding
import hbs.com.weightlessness.remote.model.JobCafe

class JobCafeListAdapter : PagedListAdapter<JobCafe, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    interface GlideLoading{
        fun onLoad()
        fun onCompleted()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemJobcafeListBinding= ItemJobcafeListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return JobCafeViewHolder(itemJobcafeListBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as JobCafeViewHolder).apply {
            itemJobcafeListBinding.jobCafe = getItem(position)
            itemJobcafeListBinding.loadingInterface = GlideLoadingImpl(itemJobcafeListBinding)
            itemJobcafeListBinding.loadingInterface?.onLoad()
        }
    }

    inner class JobCafeViewHolder(val itemJobcafeListBinding: ItemJobcafeListBinding) :
        RecyclerView.ViewHolder(itemJobcafeListBinding.root)

    class GlideLoadingImpl(private val itemJobcafeListBinding: ItemJobcafeListBinding) : GlideLoading{
        override fun onLoad() {
            itemJobcafeListBinding.lavSkeletonLoading.visibility = View.VISIBLE
            itemJobcafeListBinding.clContainer.visibility = View.GONE
        }

        override fun onCompleted() {
            itemJobcafeListBinding.lavSkeletonLoading.visibility = View.GONE
            itemJobcafeListBinding.clContainer.visibility = View.VISIBLE
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<JobCafe>() {
            override fun areItemsTheSame(oldItem: JobCafe, newItem: JobCafe) = oldItem == newItem

            override fun areContentsTheSame(oldItem: JobCafe, newItem: JobCafe) = oldItem == newItem
        }
    }
}
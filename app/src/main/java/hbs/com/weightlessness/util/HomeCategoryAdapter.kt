package hbs.com.weightlessness.util

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hbs.com.weightlessness.databinding.ItemHomeCategoryBinding
import hbs.com.weightlessness.ui.jobcafe.JobCafeActivity

class HomeCategoryAdapter(private val homeCategoryList: List<String>, private val overViewMap: HashMap<Int, Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemHomeCategoryBinding= ItemHomeCategoryBinding.inflate(LayoutInflater.from(parent.context))
        return HomeCategoryViewHolder(itemHomeCategoryBinding)
    }

    override fun getItemCount(): Int {
        return homeCategoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeCategoryViewHolder = (holder as HomeCategoryViewHolder).itemHomeCategoryBinding.apply {
            title = homeCategoryList[position]
            root.setOnClickListener { changeActivity(root.context, position) }
            overViewMap[position]?.let { totalOverView ->
                totalOverview = totalOverView.toString()
            }

        }
    }

    private fun changeActivity(context: Context, position: Int){
        when(position){
            HomeCategory.JobCafe.position -> context.startActivity(Intent(context, JobCafeActivity::class.java))
        }

    }
    inner class HomeCategoryViewHolder(val itemHomeCategoryBinding: ItemHomeCategoryBinding) : RecyclerView.ViewHolder(itemHomeCategoryBinding.root)
}
package hbs.com.weightlessness.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hbs.com.weightlessness.databinding.ItemHomeCategoryBinding

class HomeCategoryAdapter(private val homeCategoryList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemHomeCategoryBinding= ItemHomeCategoryBinding.inflate(LayoutInflater.from(parent.context))
        return HomeCategoryViewHolder(itemHomeCategoryBinding)
    }

    override fun getItemCount(): Int {
        return homeCategoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val homeCategoryViewHolder = holder as HomeCategoryViewHolder
        homeCategoryViewHolder.itemHomeCategoryBinding.title = homeCategoryList[position]
    }

    class HomeCategoryViewHolder(val itemHomeCategoryBinding: ItemHomeCategoryBinding) : RecyclerView.ViewHolder(itemHomeCategoryBinding.root)
}
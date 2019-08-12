package hbs.com.weightlessness.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import hbs.com.weightlessness.R
import kotlinx.android.synthetic.main.view_home_category.view.*

enum class HomeCategory(val position: Int){
    JobCafe(0)
}

class ViewHomeCategory @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
    private val overViewMap = hashMapOf<Int,Int>()
    private val gridLayoutManager =  GridLayoutManager(context, 2)
    private val homeCategoryAdapter  = makeHomeCategoryAdapter()
    init {
        initView()
    }

    private fun initView(){
        val view = LayoutInflater.from(context).inflate(R.layout.view_home_category, this, true)
        view.rv_category.apply{
            adapter = homeCategoryAdapter
            layoutManager = gridLayoutManager
            addItemDecoration(SpacesItemDecoration(8))
        }
    }

    private fun makeHomeCategoryAdapter(): HomeCategoryAdapter {
        val homeCategoryList = resources.getStringArray(R.array.home_category).toList()
        return HomeCategoryAdapter(homeCategoryList, overViewMap)
    }

    fun addJobCafeOverView(totalCafe:Int){
        overViewMap[HomeCategory.JobCafe.position] = totalCafe
        homeCategoryAdapter.notifyItemChanged(HomeCategory.JobCafe.position)
    }
}
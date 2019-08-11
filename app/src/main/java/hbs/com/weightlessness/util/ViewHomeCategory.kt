package hbs.com.weightlessness.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import hbs.com.weightlessness.R
import kotlinx.android.synthetic.main.view_home_category.view.*


class ViewHomeCategory @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
    init {
        initView()
    }

    private fun initView(){
        val view = LayoutInflater.from(context).inflate(R.layout.view_home_category, this, true)
        view.rv_category.apply{
            adapter = makeHomeCategoryAdapter()
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(SpacesItemDecoration(8))
        }
    }

    private fun makeHomeCategoryAdapter(): HomeCategoryAdapter {
        val homeCategoryList = resources.getStringArray(hbs.com.weightlessness.R.array.home_category).toList()
        return HomeCategoryAdapter(homeCategoryList)
    }

    private fun dd(){

    }
}
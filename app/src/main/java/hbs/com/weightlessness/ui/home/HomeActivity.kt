package hbs.com.weightlessness.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hbs.com.weightlessness.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() , HomeContract.View{
    private val presenter by lazy{
        HomePresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.getJobCafeList()
    }

    override fun updateCafeTotalCount(totalCount: Int) {
        view_home_category.addJobCafeOverView(totalCount)
    }

    override fun onPause() {
        super.onPause()
        presenter.onClear()
    }
}
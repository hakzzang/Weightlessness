package hbs.com.weightlessness.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import hbs.com.weightlessness.R
import hbs.com.weightlessness.remote.model.JobCafeList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(){
    private val presenter by lazy{
        HomePresenter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //이 부분을 뷰와 프리젠터로 분리시켜보기
        presenter.getJobCafeList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {jobCafeList->
                Log.d("jobCafeList",jobCafeList.toString())
            view_home_category.addJobCafeOverView(jobCafeList.listTotalCount)
        }
    }
}
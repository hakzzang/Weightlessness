package hbs.com.weightlessness.ui.jobcafe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import hbs.com.weightlessness.R
import hbs.com.weightlessness.util.JobCafeListAdapter
import kotlinx.android.synthetic.main.activity_jobcafe.*
import kotlinx.android.synthetic.main.view_home_category.*

class JobCafeActivity : AppCompatActivity() , JobCafeContract.View{
    private val jobCafeListAdapter = JobCafeListAdapter()
    private val jobCafePresenter = JobCafePresenter(jobCafeListAdapter, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobcafe)

        jobCafePresenter.initView()
        jobCafePresenter.getJobCafeList()
    }

    override fun initJobCafeList() {
        rv_jobcafe.apply {
            adapter = jobCafeListAdapter
            layoutManager = LinearLayoutManager(this@JobCafeActivity)
        }
    }
}
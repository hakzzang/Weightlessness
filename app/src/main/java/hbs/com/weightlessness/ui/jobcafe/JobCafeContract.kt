package hbs.com.weightlessness.ui.jobcafe

import androidx.paging.PagedList
import hbs.com.weightlessness.remote.model.JobCafe
import io.reactivex.Observable

interface JobCafeContract{
    interface View{
        fun initJobCafeList()
    }

    interface Presenter{
        fun initView()
        fun getJobCafeList()
        fun makeJobCafeList() : Observable<PagedList<JobCafe>>
    }
}
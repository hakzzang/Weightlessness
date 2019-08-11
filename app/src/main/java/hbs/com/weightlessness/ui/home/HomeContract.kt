package hbs.com.weightlessness.ui.home

import hbs.com.weightlessness.remote.model.JobCafeList
import io.reactivex.Observable

interface HomeContract {
    interface View{

    }

    interface Presenter{
        fun getJobCafeList() : Observable<JobCafeList>
    }
}
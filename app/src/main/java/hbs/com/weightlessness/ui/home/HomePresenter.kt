package hbs.com.weightlessness.ui.home

import hbs.com.weightlessness.remote.JobCafeRepositoryImpl
import hbs.com.weightlessness.remote.RetrofitProvider
import hbs.com.weightlessness.remote.model.JobCafeList
import hbs.com.weightlessness.usecase.JobCafeUseCaseImpl
import io.reactivex.Observable

class HomePresenter : HomeContract.Presenter{
    private val jobCafeUseCase = JobCafeUseCaseImpl(JobCafeRepositoryImpl(RetrofitProvider.provideSeoulApi()))

    override fun getJobCafeList(): Observable<JobCafeList> {
        return jobCafeUseCase.getJobCafeList()
    }
}
package hbs.com.weightlessness.ui.home

import hbs.com.weightlessness.remote.JobCafeRepositoryImpl
import hbs.com.weightlessness.remote.RetrofitProvider
import hbs.com.weightlessness.usecase.JobCafeUseCaseImpl
import hbs.com.weightlessness.util.BaseContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val homeView: HomeContract.View) : BaseContract.Presenter(), HomeContract.Presenter {
    private val jobCafeUseCase = JobCafeUseCaseImpl(
        JobCafeRepositoryImpl(
            RetrofitProvider.provideSeoulApi()
        )
    )

    override fun getJobCafeList() {
        addDisposable(jobCafeUseCase
            .getJobCafeList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { wrappingJobCafeList ->
                homeView.updateCafeTotalCount(wrappingJobCafeList.jobCafeList.listTotalCount)
            })
    }
}
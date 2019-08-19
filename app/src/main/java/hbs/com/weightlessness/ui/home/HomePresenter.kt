package hbs.com.weightlessness.ui.home

import hbs.com.weightlessness.remote.JobCafeRepositoryImpl
import hbs.com.weightlessness.remote.RetrofitProvider
import hbs.com.weightlessness.usecase.JobCafeDataSourceImpl
import hbs.com.weightlessness.usecase.JobCafeDataSourceImpl.Companion.FIRST_PAGE
import hbs.com.weightlessness.util.BaseContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val homeView: HomeContract.View) : BaseContract.Presenter(), HomeContract.Presenter {
    private val jobCafeDataSource =
        JobCafeDataSourceImpl(JobCafeRepositoryImpl(RetrofitProvider.provideSeoulApi()), this)

    override fun getJobCafeList() {
        addDisposable(jobCafeDataSource
            .getJobCafeList(FIRST_PAGE, FIRST_PAGE)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { wrappingJobCafeList ->
                homeView.updateCafeTotalCount(wrappingJobCafeList.jobCafeList.listTotalCount)
            })
    }
}
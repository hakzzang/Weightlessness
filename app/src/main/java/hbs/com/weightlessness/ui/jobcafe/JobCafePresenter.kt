package hbs.com.weightlessness.ui.jobcafe

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import hbs.com.weightlessness.remote.model.JobCafe
import hbs.com.weightlessness.remote.model.JobCafeDataFactory
import hbs.com.weightlessness.usecase.JobCafeDataSourceImpl.Companion.PAGE_SIZE
import hbs.com.weightlessness.util.BaseContract
import hbs.com.weightlessness.util.JobCafeListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class JobCafePresenter(
    private val jobCafeListAdapter: JobCafeListAdapter,
    private val jobCafeView: JobCafeContract.View
) :
    BaseContract.Presenter(), JobCafeContract.Presenter {
    override fun initView() {
        jobCafeView.initJobCafeList()
    }

    override fun makeJobCafeList(): Observable<PagedList<JobCafe>> {
        val jobCafeDataSourceFactory = JobCafeDataFactory(this)
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(PAGE_SIZE)
            .setPrefetchDistance(1)
            .build()

        return RxPagedListBuilder(jobCafeDataSourceFactory, pagedListConfig).buildObservable()
    }

    override fun getJobCafeList() {
        addDisposable(makeJobCafeList()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
                jobCafeListAdapter.submitList(it)
            })
    }
}
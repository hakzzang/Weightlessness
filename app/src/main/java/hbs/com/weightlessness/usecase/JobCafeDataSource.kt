package hbs.com.weightlessness.usecase

import androidx.paging.PageKeyedDataSource
import hbs.com.weightlessness.remote.JobCafeRepository
import hbs.com.weightlessness.remote.model.JobCafe
import hbs.com.weightlessness.remote.model.WrappingJobCafeList
import hbs.com.weightlessness.util.BaseContract
import io.reactivex.Observable


interface JobCafeDataSource {
    fun getJobCafeList(startIndex: Int, endIndex: Int): Observable<WrappingJobCafeList>
}

class JobCafeDataSourceImpl(
    private val jobCafeRepository: JobCafeRepository,
    private val basePresenter: BaseContract.Presenter?
) : PageKeyedDataSource<Int, JobCafe>(),
    JobCafeDataSource {
    companion object {
        const val PAGE_SIZE = 10
        const val FIRST_PAGE = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, JobCafe>) {
        basePresenter?.addDisposable(getJobCafeList(FIRST_PAGE, FIRST_PAGE + PAGE_SIZE).subscribe {
            callback.onResult(it.jobCafeList.jobCafes, null, FIRST_PAGE + PAGE_SIZE)
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, JobCafe>) {
        basePresenter?.addDisposable(getJobCafeList(params.key, params.key + params.requestedLoadSize).subscribe {
            val paramKey = if (params.key > PAGE_SIZE) params.key - PAGE_SIZE else 0
            callback.onResult(it.jobCafeList.jobCafes, paramKey)
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, JobCafe>) {
        basePresenter?.addDisposable(getJobCafeList(params.key+1, params.key + params.requestedLoadSize).subscribe {
            if (params.key + PAGE_SIZE < it.jobCafeList.listTotalCount) {
                callback.onResult(it.jobCafeList.jobCafes, params.key + PAGE_SIZE)
            } else params.key
        })
    }

    override fun getJobCafeList(startIndex: Int, endIndex: Int): Observable<WrappingJobCafeList> {
        return jobCafeRepository.getJobCafeList()
    }
}
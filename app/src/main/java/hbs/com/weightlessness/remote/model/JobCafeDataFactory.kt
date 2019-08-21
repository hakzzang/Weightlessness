package hbs.com.weightlessness.remote.model

import androidx.paging.DataSource
import hbs.com.weightlessness.remote.JobCafeRepositoryImpl
import hbs.com.weightlessness.remote.RetrofitProvider
import hbs.com.weightlessness.usecase.JobCafeDataSourceImpl
import hbs.com.weightlessness.util.BaseContract

class JobCafeDataFactory(basePresenter : BaseContract.Presenter) : DataSource.Factory<Int, JobCafe>() {
    private val jobCafeDataSource = JobCafeDataSourceImpl(JobCafeRepositoryImpl(RetrofitProvider.provideSeoulApi()), basePresenter)

    override fun create(): DataSource<Int, JobCafe> {
        return jobCafeDataSource
    }
}
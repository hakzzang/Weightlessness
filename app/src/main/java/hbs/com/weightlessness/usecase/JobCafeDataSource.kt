package hbs.com.weightlessness.usecase

import hbs.com.weightlessness.remote.JobCafeRepository
import hbs.com.weightlessness.remote.model.WrappingJobCafeList
import io.reactivex.Observable

interface JobCafeDataSource {
    fun getJobCafeList() : Observable<WrappingJobCafeList>
}

class JobCafeDataSourceImpl(private val jobCafeRepository: JobCafeRepository) : JobCafeDataSource{
    override fun getJobCafeList() : Observable<WrappingJobCafeList> {
        return jobCafeRepository.getJobCafeList()
    }
}
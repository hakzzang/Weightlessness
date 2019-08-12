package hbs.com.weightlessness.usecase

import hbs.com.weightlessness.remote.JobCafeRepository
import hbs.com.weightlessness.remote.model.WrappingJobCafeList
import io.reactivex.Observable

interface JobCafeUseCase {
    fun getJobCafeList() : Observable<WrappingJobCafeList>
}

class JobCafeUseCaseImpl(private val jobCafeRepository: JobCafeRepository) : JobCafeUseCase{
    override fun getJobCafeList() : Observable<WrappingJobCafeList> {
        return jobCafeRepository.getJobCafeList()
    }
}
package hbs.com.weightlessness.usecase

import hbs.com.weightlessness.remote.JobCafeRepository
import hbs.com.weightlessness.remote.model.JobCafeList
import io.reactivex.Observable

interface JobCafeUseCase {
    fun getJobCafeList() : Observable<JobCafeList>
}

class JobCafeUseCaseImpl(private val jobCafeRepository: JobCafeRepository) : JobCafeUseCase{
    override fun getJobCafeList() : Observable<JobCafeList> {
        return jobCafeRepository.getJobCafeList()
    }
}
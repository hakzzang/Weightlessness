package hbs.com.weightlessness.remote

import hbs.com.weightlessness.remote.model.JobCafeList
import hbs.com.weightlessness.remote.model.WrappingJobCafeList
import io.reactivex.Observable

interface JobCafeRepository{
    fun getJobCafeList(
        apiKey: String,
        format: String,
        appTitle: String,
        startIndex: String,
        endIndex: String
    ): Observable<WrappingJobCafeList>
}

class JobCafeRepositoryImpl(private val seoulAPI: SeoulAPI) : JobCafeRepository{
    override fun getJobCafeList(apiKey:String, format:String, appTitle:String, startIndex:String, endIndex:String): Observable<WrappingJobCafeList> {
        return seoulAPI.getJobCafeList(apiKey, format, appTitle, startIndex, endIndex)
    }
}
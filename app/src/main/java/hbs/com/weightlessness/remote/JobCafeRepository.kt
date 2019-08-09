package hbs.com.weightlessness.remote

import hbs.com.weightlessness.remote.model.JobCafeList
import io.reactivex.Observable

interface JobCafeRepository{
    fun getJobCafeList(
        apiKey: String,
        format: String,
        appTitle: String,
        startIndex: String,
        endIndex: String
    ): Observable<JobCafeList>
}

class JobCafeRepositoryImpl(private val seoulAPI: SeoulAPI) : JobCafeRepository{
    override fun getJobCafeList(apiKey:String, format:String, appTitle:String, startIndex:String, endIndex:String): Observable<JobCafeList> {
        return seoulAPI.getJobCafeList(apiKey, format, appTitle, startIndex, endIndex)
    }
}
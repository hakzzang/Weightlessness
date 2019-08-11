package hbs.com.weightlessness.remote

import hbs.com.weightlessness.remote.model.JobCafeList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface SeoulAPI{
    @GET("{apiKey}/{format}/{apiTitle}/{startIndex}/{endIndex}")
    fun getJobCafeList(
        @Path("apiKey") apiKey:String,
        @Path("format") format:String,
        @Path("apiTitle") apiTitle:String,
        @Path("startIndex") startIndex:String,
        @Path("endIndex") endIndex:String
    ) : Observable<JobCafeList>
}
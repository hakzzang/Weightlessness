package hbs.com.weightlessness.remote

import hbs.com.weightlessness.remote.model.JobCafeList
import hbs.com.weightlessness.remote.model.WrappingJobCafeList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface SeoulAPI{

    @Headers("Content-Type: application/json")
    @GET("{apiKey}/{format}/{apiTitle}/{startIndex}/{endIndex}")
    fun getJobCafeList(
        @Path("apiKey") apiKey:String,
        @Path("format") format:String,
        @Path("apiTitle") apiTitle:String,
        @Path("startIndex") startIndex:String,
        @Path("endIndex") endIndex:String
    ) : Observable<WrappingJobCafeList>
}
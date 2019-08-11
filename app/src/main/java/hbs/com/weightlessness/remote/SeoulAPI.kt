package hbs.com.weightlessness.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface SeoulAPI{
    @GET("{apiKey}/{format}/{apiTitle}/{startIndex}/{endIndex}")
    fun<T> getJobCafeList(
        @Path("apiKey") apiKey:String,
        @Path("format") format:String,
        @Path("apiTitle") apiTitle:String,
        @Path("startIndex") startIndex:String,
        @Path("endIndex") endIndex:String
    ) : Observable<T>
}
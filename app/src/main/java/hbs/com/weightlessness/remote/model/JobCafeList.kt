package hbs.com.weightlessness.remote.model

import com.google.gson.annotations.SerializedName

data class JobCafeList(
    @SerializedName("list_total_count") val listTotalCount:Int,
    @SerializedName("RESULT") val SeoulApiResult:ApiResult,
    @SerializedName("row") val jobCafes:List<JobCafe>
)
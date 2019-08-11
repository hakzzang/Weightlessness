package hbs.com.weightlessness.remote.model

import com.google.gson.annotations.SerializedName

data class JobCafeList(
    @SerializedName("list_total_count") private val listTotalCount:Int,
    @SerializedName("RESULT") private val SeoulApiResult:ApiResult,
    @SerializedName("row") private val jobCafes:List<JobCafe>
)
package hbs.com.weightlessness.remote.model

import com.google.gson.annotations.SerializedName

data class WrappingJobCafeList(@SerializedName("jobCafeOpenInfo") val jobCafeList: JobCafeList)
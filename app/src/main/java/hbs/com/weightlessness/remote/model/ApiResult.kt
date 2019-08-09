package hbs.com.weightlessness.remote.model

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("CODE") val code:String,
    @SerializedName("MESSAGE") val message:String)
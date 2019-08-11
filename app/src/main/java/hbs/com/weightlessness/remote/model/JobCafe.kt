package hbs.com.weightlessness.remote.model

import com.google.gson.annotations.SerializedName

data class JobCafe(
    @SerializedName("CAFE_NM") val cafeNM:String,
    @SerializedName("SMPL_INTRO") val smplIntro:String,
    @SerializedName("USE_DT") val useDt:String,
    @SerializedName("HOLI_DD") val holiDd:String,
    @SerializedName("FACLT_INFO1") val facltInfo1:String,
    @SerializedName("FACLT_INFO2") val facltInfo2:String,
    @SerializedName("FACLT_INFO3") val facltInfo3:String,
    @SerializedName("FACLT_INFO4") val facltInfo4:String,
    @SerializedName("FACLT_INFO5") val facltInfo5:String,
    @SerializedName("FACLT_INFO6") val facltInfo6:String,
    @SerializedName("FACLT_INFO7") val facltInfo7:String,
    @SerializedName("FACLT_INFO8") val facltInfo8:String,
    @SerializedName("FACLT_INFO9") val facltInfo9:String,
    @SerializedName("FACLT_INF10") val facltInfo10:String,
    @SerializedName("RSRV_SGGST1") val rsrvSggst1:String,
    @SerializedName("RSRV_SGGST2") val rsrvSggst2:String,
    @SerializedName("RSRV_SGGST3") val rsrvSggst3:String,
    @SerializedName("RSRV_SGGST4") val rsrvSggst4:String,
    @SerializedName("RSRV_SGGST5") val rsrvSggst5:String,
    @SerializedName("RSRV_SGGST6") val rsrvSggst6:String,
    @SerializedName("RSRV_SGGST7") val rsrvSggst7:String,
    @SerializedName("RSRV_SGGST8") val rsrvSggst8:String,
    @SerializedName("RSRV_SGGST9") val rsrvSggst9:String,
    @SerializedName("RSRV_SGGST10") val rsrvSggst10:String,
    @SerializedName("GUGUN") val gugun:String,
    @SerializedName("ROAD_ADRES2_CN") val roadAdres2Cn:String,
    @SerializedName("APPR_MTHD_NM") val apprMthdNm:String,
    @SerializedName("FILE_NM") val fileNm:String,
    @SerializedName("CAFE_TYPE_NM") val cafeTypeNm:String
)
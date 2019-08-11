package hbs.com.weightlessness.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
object SeoulRetrofitProvider{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://openapi.seoul.go.kr:8088/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideSeoulApi(): SeoulAPI = SeoulRetrofitProvider.retrofit.create(SeoulAPI::class.java)
}
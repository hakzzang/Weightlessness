package hbs.com.weightlessness.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
object RetrofitProvider{
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }
    private val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://openapi.seoul.go.kr:8088/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    fun provideSeoulApi(): SeoulAPI = RetrofitProvider.retrofit.create(SeoulAPI::class.java)
}
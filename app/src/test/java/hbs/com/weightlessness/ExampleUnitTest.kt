package hbs.com.weightlessness

import android.util.Log
import hbs.com.weightlessness.remote.JobCafeRepositoryImpl
import hbs.com.weightlessness.remote.RetrofitProvider
import hbs.com.weightlessness.usecase.JobCafeDataSource
import hbs.com.weightlessness.usecase.JobCafeDataSourceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var jobCafeUseCase: JobCafeDataSource
    @Before
    fun setupTest() {
        jobCafeUseCase = JobCafeDataSourceImpl(
            JobCafeRepositoryImpl(
                RetrofitProvider.provideSeoulApi()
            )
        )
    }

    @Test
    fun getJobCafe() {
        jobCafeUseCase
            .getJobCafeList()
            .subscribe { wrappingJobCafeList ->
                println(wrappingJobCafeList.jobCafeList.jobCafes.toString())
            }
    }
}

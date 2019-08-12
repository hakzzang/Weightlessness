package hbs.com.weightlessness.ui.home

interface HomeContract {
    interface View{
        fun updateCafeTotalCount(totalCount:Int)
    }

    interface Presenter{
        fun getJobCafeList()
    }
}
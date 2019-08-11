package hbs.com.weightlessness.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hbs.com.weightlessness.R


class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        val spaceDp= (space * view.resources.getDimension(R.dimen.dp_1)).toInt()
        outRect.apply {
            left = spaceDp / 2
            right = spaceDp / 2
            bottom = (spaceDp / 1.5).toInt()
            top = (spaceDp / 1.5).toInt()
        }
    }
}
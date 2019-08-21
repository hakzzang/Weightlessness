package hbs.com.weightlessness.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import hbs.com.weightlessness.R
import hbs.com.weightlessness.util.JobCafeListAdapter

@BindingAdapter("bindImage","bindLoadingInterface")
fun ImageView.bindImageWithGlide(imgUrl:String, bindLoadingInterface: JobCafeListAdapter.GlideLoading){
    Glide.with(this)
        .load(imgUrl)
        .thumbnail(0.1f)
        .override(this.measuredWidth, this.measuredHeight)
        .apply(RequestOptions.circleCropTransform())
        .listener(object : RequestListener<Drawable>{
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                bindLoadingInterface.onCompleted()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                bindLoadingInterface.onCompleted()
                return false
            }
        }).placeholder(R.drawable.no_connected_image)
        .into(this)
}
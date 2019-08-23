package hbs.com.weightlessness.ui.chat

import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import hbs.com.weightlessness.util.AnimationUtils

interface ChatContract {
    interface View {
        fun updateChatRooms()
        fun sendChatting()
        fun addSendListener()
        fun clearEditText()
        fun addTextWatcherForAnimation()
        fun initRecyclerView()
        fun addAnimation(view: ImageView, animationType: AnimationUtils.AnimationType)
        fun changeImageResource(imageView: ImageView, resource: Int)
    }

    interface Presenter {
        fun getChatContents()
        fun getChatRooms()
        fun sendChatting()
        fun initView()
        fun makeTextWatcher(backgroundView: ImageView, iconView: ImageView): TextWatcher
        fun changeImageResource(imageView: ImageView, animationType: AnimationUtils.AnimationType)
    }
}

package hbs.com.weightlessness.ui.chat

import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import hbs.com.weightlessness.R
import hbs.com.weightlessness.util.AnimationUtils

class ChatPresenterImpl(private val chatContractView: ChatContract.View) : ChatContract.Presenter {
    override fun initView() {
        chatContractView.addSendListener()
        chatContractView.addTextWatcherForAnimation()
        chatContractView.initRecyclerView()
    }

    override fun sendChatting() {
        chatContractView.sendChatting()
        chatContractView.clearEditText()
    }

    override fun getChatContents() {

    }

    override fun getChatRooms() {

    }

    override fun makeTextWatcher(backgroundView: ImageView, iconView: ImageView): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (before == 0 && count > 0) {
                    chatContractView.addAnimation(backgroundView, AnimationUtils.AnimationType.EMPTY_TO_FULL)
                    chatContractView.addAnimation(iconView, AnimationUtils.AnimationType.EMPTY_TO_FULL)
                } else if (before > 0 && count == 0) {
                    chatContractView.addAnimation(backgroundView, AnimationUtils.AnimationType.FULL_TO_EMPTY)
                    chatContractView.addAnimation(iconView, AnimationUtils.AnimationType.FULL_TO_EMPTY)
                }
            }
        }
    }

    override fun changeImageResource(imageView: ImageView, animationType: AnimationUtils.AnimationType) {
        when (imageView.id) {
            R.id.iv_send_chat_container -> {
                if(animationType == AnimationUtils.AnimationType.EMPTY_TO_FULL){
                    chatContractView.changeImageResource(imageView, R.drawable.bg_send_chat_on)
                }else{
                    chatContractView.changeImageResource(imageView, R.drawable.bg_send_chat_off)
                }
            }
            R.id.iv_send_chat_icon -> {
                if(animationType == AnimationUtils.AnimationType.EMPTY_TO_FULL){
                    chatContractView.changeImageResource(imageView, R.drawable.ic_send_button_on)
                }else{
                    chatContractView.changeImageResource(imageView, R.drawable.ic_send_button_off)
                }
            }
        }
    }
}
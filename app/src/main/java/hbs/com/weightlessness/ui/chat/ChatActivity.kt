package hbs.com.weightlessness.ui.chat

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hbs.com.weightlessness.R
import hbs.com.weightlessness.util.AnimationUtils
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity(), ChatContract.View {
    private val chattingList = mutableListOf<String>()
    private val presenter by lazy {
        ChatPresenterImpl(this)
    }
    private val chattingAdapter by lazy {
        ChattingAdapter(chattingList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        presenter.initView()
    }

    override fun initRecyclerView() {
        rv_chat.apply {
            adapter = chattingAdapter
            layoutManager = LinearLayoutManager(this@ChatActivity)
        }
    }

    override fun addTextWatcherForAnimation() {
        et_send_chat.apply {
            val textWatcher = presenter.makeTextWatcher(iv_send_chat_container, iv_send_chat_icon)
            addTextChangedListener(textWatcher)
        }
    }


    override fun clearEditText() {
        et_send_chat.setText("")
    }

    override fun sendChatting() {
        chattingList.add(et_send_chat.text.toString())
    }

    override fun updateChatRooms() {

    }

    override fun addSendListener() {
        iv_send_chat_icon.setOnClickListener {
            presenter.sendChatting()
        }
    }

    override fun addAnimation(view: ImageView, animationType: AnimationUtils.AnimationType) {
        val scaleAnimatorListener =
            AnimationUtils.addAnimateListener(presenter, view, animationType)
        AnimationUtils.animateScale(view, scaleAnimatorListener)
    }

    override fun changeImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}
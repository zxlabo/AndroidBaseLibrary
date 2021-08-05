package com.demo.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import com.demo.other.MessageEvent
import kotlinx.android.synthetic.main.activity_heart.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class HeartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart)


        btn_heart.setOnClickListener {
//            HeartBeatAnimationUtil.with(mImageLogo)
//                .scaleFrom(1.0f)
//                .scaleTo(1.40f)
//                .reduce(100)
//                .enlarge(500)
//                .start()

//            HeartBeatAnimationUtil.with(mImageLogo)
////                .scaleFrom(1.0f)
////                .scaleTo(0.8f)
//                .scaleFrom(1.0f)
//                .scaleTo(2.4f)
//                .duration(10)
//                .delay(500)
//                .start()
            heartAnimation(mImageLogo, 500)
        }
    }

    private fun heartAnimation(view: ImageView, duration: Long) {
        val anim1 = ObjectAnimator.ofFloat(view, "scaleX", 1.2f, 0.8f)
        anim1.repeatCount = -1
        val anim2 = ObjectAnimator.ofFloat(view, "scaleY", 1.2f, 0.8f)
        anim2.repeatCount = -1
        val set = AnimatorSet()
        set.play(anim1).with(anim2)
        set.duration = duration
        set.start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent?) { /* Do something */
    }
}
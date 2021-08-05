package com.demo.other

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.base.R
import kotlinx.android.synthetic.main.activity_media.*

@Route(path = "/shop/order")
class MediaActivity : AppCompatActivity(), MediaPlayer.OnCompletionListener {
    private var mPlayer: MediaPlayer? = null
    private var mNextPlayer: MediaPlayer? = null
    private val source = "http://up.boohee.cn/house/u/one/sleep_music/465_20180112.m4a"
    var isBegin = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)
        btn_media.setOnClickListener {
            if (isBegin) {
                initMedia()
            } else {
                release()
            }
            isBegin = !isBegin


        }
    }

    private fun release() {
        mPlayer?.release()
        mNextPlayer?.release()
        mPlayer = null
        mNextPlayer = null
    }

    private fun initMedia() {
        mPlayer = MediaPlayer.create(this, R.raw.water)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener(this)
        createNextPlayer()
    }

    override fun onCompletion(mp: MediaPlayer?) {
        if (mPlayer != null) {
            mPlayer?.release()
        }
        mPlayer = mNextPlayer
        createNextPlayer()
    }

    /**
     * 创建下一个player
     */
    private fun createNextPlayer() {
        mNextPlayer = MediaPlayer.create(this, R.raw.water)
        mNextPlayer?.setOnCompletionListener(this)
        mPlayer?.setNextMediaPlayer(mNextPlayer)
    }


}
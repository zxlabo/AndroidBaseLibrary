package com.demo.main

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.activity.viewModels
import com.alibaba.android.arouter.launcher.ARouter
import com.base.databinding.ActivityMainBinding
import com.baselibrary.base.BaseVmActivity
import com.utils.ext.setOnAvoidClickListener
import com.demo.RichTextActivity
import com.demo.activity.CommonPdfActivity
import com.demo.activity.PDF_URL_KEY
import com.demo.activity.RegionSelectActivity
import com.demo.fragment.MyFragmentActivity
import com.demo.fragment.vp.ViewPagerActivity
import com.demo.fragment.vp2.ViewPager2Activity
import com.demo.glide.GlideActivity
import com.demo.glide.ImageActivity
import com.demo.jetpack.LiveDataActivity
import com.demo.jetpack.room.RoomActivity
import com.demo.jetpack.workmanager.WorkActivity
import com.demo.kotlin.CoroutineActivity
import com.demo.other.MediaActivity
import com.demo.other.MenuActivity
import com.demo.other.ViewFlipperActivity
import com.demo.view.HeartActivity
import com.demo.view.ProgressActivity
import com.recy.*
import com.utils.ext.inflate
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern


class MainActivity : BaseVmActivity<MainViewModel>() {

    override val mVm: MainViewModel by viewModels()
    private val mBinding:ActivityMainBinding by inflate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title="首页"
        setContentView(mBinding.root)
        initListener()
    }


    private fun initListener() {
        btn_test.setOnAvoidClickListener {
            ARouter.getInstance().build("/shop/order").navigation();
        }
        btn_media.setOnAvoidClickListener {
            startActivity(Intent(this, MediaActivity::class.java))
        }
        btn_address.setOnAvoidClickListener {
            startActivity(Intent(this, RegionSelectActivity::class.java))
        }
        btn_vp.setOnAvoidClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
        btn_vp2.setOnAvoidClickListener {
            startActivity(Intent(this, ViewPager2Activity::class.java))
        }
        btn_heart.setOnAvoidClickListener {
            startActivity(Intent(this, HeartActivity::class.java))
        }
        btn_leak.setOnAvoidClickListener {
        }
        btn_livedata.setOnAvoidClickListener {
            startActivity(Intent(this, LiveDataActivity::class.java))
        }
        btn_progress.setOnAvoidClickListener {
            startActivity(Intent(this, ProgressActivity::class.java))
        }
        btn_view_flipper.setOnAvoidClickListener {
            startActivity(Intent(this, ViewFlipperActivity::class.java))
        }
        btn_menu.setOnAvoidClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        btn_glide.setOnAvoidClickListener {
            startActivity(Intent(this, GlideActivity::class.java))
        }
        btn_img.setOnAvoidClickListener {
            startActivity(Intent(this, ImageActivity::class.java))
        }
        btn_coroutine.setOnAvoidClickListener {
            startActivity(Intent(this, CoroutineActivity::class.java))
        }
        btn_recyclerview_1.setOnAvoidClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
        btn_recy.setOnAvoidClickListener {
            startActivity(Intent(this, RecyclerViewClickActivity::class.java))
        }
        btn_layout_manager.setOnAvoidClickListener {
            startActivity(Intent(this, RecyActivity2::class.java))
        }

        btn_snap_helper.setOnAvoidClickListener {
            startActivity(Intent(this, SnapHelperActivity::class.java))
        }
        btn_diff_utils.setOnAvoidClickListener {
            startActivity(Intent(this, DiffUtilActivity::class.java))
        }
        btn_room.setOnAvoidClickListener {
            startActivity(Intent(this, RoomActivity::class.java))
        }
        btn_work.setOnAvoidClickListener {
            startActivity(Intent(this, WorkActivity::class.java))
        }
        btn_rich_text.setOnAvoidClickListener {
            startActivity(Intent(this, RichTextActivity::class.java))
        }
        btn_fragment.setOnAvoidClickListener {
            startActivity(Intent(this, MyFragmentActivity::class.java))
        }
        btn_pdf.setOnAvoidClickListener {
            val intent = Intent(this, CommonPdfActivity::class.java)
            intent.putExtra(
                PDF_URL_KEY,
                "http://xz.bwfapiao.com/913100006778687843/031002000411/031002000411_06344501.pdf?Expires=1918792155&OSSAccessKeyId=LTAIB3SkRb2V8Vu1&Signature=BoBystyYaPSzeoT%2F55DeQ7mMrtc%3D"
            )
            startActivity(intent)
        }


    }



    private fun setBoldText(strMsg: String) {
        var str = strMsg
        val pa = "(\\$).*?(\\$)"
        val matcher = Pattern.compile(pa).matcher(str)
        val stringBuilder = SpannableStringBuilder()
        while (matcher.find()) {
            val boldText = matcher.group()
            val msg = str.substring(0, str.indexOf(boldText))
            stringBuilder.append(msg)
            val boldText2 = boldText.substring(1, boldText.length - 1)
            val boldSpan = SpannableString(boldText2)
            boldSpan.setSpan(
                StyleSpan(Typeface.BOLD),
                0, boldText2.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            stringBuilder.append(boldSpan)
            str = str.replace(msg + boldText, "")

        }
        stringBuilder.append(str)
        btn_test.text = stringBuilder
    }



}

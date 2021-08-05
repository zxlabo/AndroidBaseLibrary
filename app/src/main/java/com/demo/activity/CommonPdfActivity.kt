package com.demo.activity

import android.os.Bundle
import android.text.TextUtils
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import com.baselibrary.utils.FileUtils
import com.baselibrary.utils.file.DownloadHelper
import com.baselibrary.utils.file.PDFUtils
import com.baselibrary.utils.file.PdfDownLoadCallBack
import com.tencent.smtt.sdk.TbsReaderView
import kotlinx.android.synthetic.main.activity_common_pdf.*

const val PDF_URL_KEY="pdf_url_key"

class CommonPdfActivity : AppCompatActivity() {

    var mPdfUrl: String? = null
    private var tbsReaderView: TbsReaderView? = null
    var readerCallback = TbsReaderView.ReaderCallback { _, _, _ -> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPdfUrl=intent.getStringExtra(PDF_URL_KEY)
        setContentView(R.layout.activity_common_pdf)
        if (TextUtils.isEmpty(mPdfUrl)) {
        } else {
            loadPdf(mPdfUrl!!)
        }
    }

    private fun loadPdf(pdfUrl: String) {
        val tempPath = FileUtils.getCacheDir(this, DownloadHelper.PDF_DOWNLOAD_PATH).path
        tbsReaderView = TbsReaderView(this, readerCallback)
        frame_pdf_content.addView(
                tbsReaderView,
                RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                )
        )
        PDFUtils.downloadAndViewPDF(this, pdfUrl, object : PdfDownLoadCallBack {
            override fun onFailure(msg: String?) {
//                BHToastUtil.show(msg)
            }

            override fun onSuccess(filePath: String?) {
                if (TextUtils.isEmpty(filePath)) return
                runOnUiThread {
                    val url = filePath!!
                    val bundle = Bundle()
                    bundle.putString("filePath", url)
                    //存放临时文件的目录。运行后，会在path2的目录下生成.tbs...的文件
                    bundle.putString("tempPath", tempPath)
                    val result: Boolean = tbsReaderView?.preOpen(PDFUtils.urlParseFormat(url), false)
                            ?: false
                    if (result) {
                        tbsReaderView?.openFile(bundle)
                    }
                }
            }

        })
    }

    override fun onStop() {
        super.onStop()
        //在展示结束的时候，一定要调用。否则一直处于加载状态
        tbsReaderView?.onStop();
    }


}
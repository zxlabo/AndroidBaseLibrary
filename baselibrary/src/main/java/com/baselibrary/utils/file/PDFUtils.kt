package com.baselibrary.utils.file

import android.content.Context
import android.text.TextUtils
import com.baselibrary.utils.FileUtils
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


interface PdfDownLoadCallBack {
    fun onFailure(msg: String?)
    fun onSuccess(filePath: String?)
}

object PDFUtils {

    /**
     * 下载pdf
     */
    @JvmStatic
    fun downloadAndViewPDF(context: Context, pdfUrl: String, callBack: PdfDownLoadCallBack?) {
        if (TextUtils.isEmpty(pdfUrl)) return
        // 加密之后的文件名
        // val fileName = DownloadHelper.getInstance().getPDFFileName(pdfUrl)
        // TODO: 2020/11/4  所有的pdf设置同样的名字，为了保证所有的电子发票只保留一份。
        val fileName = DownloadHelper.getPDFFileName("pdfUrl")
        // 本地缓存pdf件夹
        val folder = FileUtils.getCacheDir(context, DownloadHelper.PDF_DOWNLOAD_PATH)
        val filePath = folder.absolutePath + "/" + fileName
        val file = File(filePath)
        //为什么文件存在，要删除呢？不能保证同一个链接下面的电子发票是否内容更新。所以重新下载。
        if (file.exists()) {
            file.delete()
        }
        FileDownLoadOkHttpUtils.getInstance().download(pdfUrl, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callBack?.onFailure("文档下载失败" + e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                //下载功能
                response.body?.byteStream()?.let { inputStream ->
                    val outputStream = FileOutputStream(File(filePath))
                    val by = ByteArray(2048)
                    var len = 0
                    while (inputStream.read(by).also { len = it } != -1) {
                        outputStream.write(by, 0, len)
                    }
                    outputStream.flush()
                    callBack?.onSuccess(filePath)
                }
            }
        })
    }

    fun urlParseFormat(url: String): String {
        return parseFormat(parseName(url))
    }

    private fun parseFormat(fileName: String): String {
        return fileName.substring(fileName.lastIndexOf(".") + 1)
    }

    private fun parseName(url: String): String {
        var fileName: String = ""
        try {
            fileName = url.substring(url.lastIndexOf("/") + 1)
        } finally {
            if (TextUtils.isEmpty(fileName)) {
                fileName = System.currentTimeMillis().toString()
            }
        }
        return fileName
    }
}
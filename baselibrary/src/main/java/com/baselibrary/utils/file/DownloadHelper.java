package com.baselibrary.utils.file;


import com.baselibrary.utils.FileUtils;

public class DownloadHelper {

    public static final String PDF_DOWNLOAD_PATH = "pdf";
    public static final String PDF = ".pdf";

    /**
     * 获取pdf下载的名字
     *
     * @param pdfUrl
     */
    public static String getPDFFileName(String pdfUrl) {
        return FileUtils.generateMD5FileName(pdfUrl) + PDF;
    }

}

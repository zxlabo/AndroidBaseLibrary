package com;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * author : Naruto
 * date   : 2020/11/3
 * desc   :
 * version:
 */
public class DownLoadFile {

    private static final String TAG = "download";

    //    http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf
    public static void downloadFile1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //下载路径，如果路径无效了，可换成你的下载路径
//        String url = "http://c.qijingonline.com/test.mkv";
                    String url = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();

                    final long startTime = System.currentTimeMillis();
                    Log.i("DOWNLOAD", "startTime=" + startTime);
                    //下载函数
                    String filename = url.substring(url.lastIndexOf("/") + 1);
                    //获取文件名
                    URL myURL = new URL(url);
                    URLConnection conn = myURL.openConnection();
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    int fileSize = conn.getContentLength();//根据响应获取文件大小
                    Log.i("DOWNLOAD", "fileSize=" + fileSize);
                    if (fileSize <= 0) throw new RuntimeException("无法获知文件大小 ");
                    if (is == null) throw new RuntimeException("stream is null");
                    File file1 = new File(path);
                    if (file1.exists()){
                        file1.delete();
                    }
                    if (!file1.exists()) {
                        file1.mkdirs();
                    }
                    //把数据存入路径+文件名
                    FileOutputStream fos = new FileOutputStream(path + "/" + filename);
                    byte buf[] = new byte[1024];
                    int downLoadFileSize = 0;
                    do {
                        //循环读取
                        int numread = is.read(buf);
                        if (numread == -1) {
                            break;
                        }
                        fos.write(buf, 0, numread);
                        downLoadFileSize += numread;
                        //更新进度条
                    } while (true);

                    Log.i("DOWNLOAD", "download success");
                    Log.i("DOWNLOAD", "totalTime=" + (System.currentTimeMillis() - startTime));
                    Log.i("DOWNLOAD", file1.getAbsolutePath());

                    is.close();
                } catch (Exception ex) {
                    Log.e("DOWNLOAD", "error: " + ex.getMessage(), ex);
                }
            }
        }).start();

    }

    public static void download() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
//                   String downloadUrl="http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
                   String downloadUrl = "https://ae01.alicdn.com/kf/U6202539a67334352a008ff082ea99ded5.jpg";
                   URL url = new URL(downloadUrl);
                   //打开连接
                   URLConnection conn = url.openConnection();
                   //打开输入流
                   InputStream is = conn.getInputStream();
                   //获得长度
                   int contentLength = conn.getContentLength();
                   Log.e(TAG, "contentLength = " + contentLength);
                   //创建文件夹 MyDownLoad，在存储卡下
                   String dirName = Environment.getExternalStorageDirectory() + "/MyDownLoad/";
                   File file = new File(dirName);
                   //不存在创建
                   if (!file.exists()) {
                       file.mkdir();
                   }
                   //下载后的文件名
                   String fileName = dirName + "ded5.jpg";
                   File file1 = new File(fileName);
                   if (file1.exists()) {
                       file1.delete();
                   }
                   //创建字节流
                   byte[] bs = new byte[1024];
                   int len;
                   OutputStream os = new FileOutputStream(fileName);
                   //写数据
                   while ((len = is.read(bs)) != -1) {
                       os.write(bs, 0, len);
                   }
                   //完成后关闭流
                   Log.e(TAG, "download-finish"+file1.getAbsolutePath());
                   os.close();
                   is.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }

}


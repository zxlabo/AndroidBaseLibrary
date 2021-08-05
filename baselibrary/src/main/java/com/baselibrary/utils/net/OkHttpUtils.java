package com.baselibrary.utils.net;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * author : Naruto
 * date   : 2020/11/19
 * desc   :
 * version:
 */
public class OkHttpUtils {
    /**
     * 将字符串转为RequestBody
     */
    public static RequestBody convertStringToBody(String str) {
        try {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"),str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将map数据转换为 普通的 json RequestBody
     * @param map 以前的请求参数
     * @return
     */
    public static RequestBody convertMapToBody(Map<?,?> map) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new JSONObject(map).toString());
    }

    /**
     * 将map数据转换为图片，文件类型的  RequestBody
     * @param map 以前的请求参数
     * @return 待测试
     */
    public static RequestBody convertMapToMediaBody(Map<?,?> map) {
        return RequestBody.create(MediaType.parse("multipart/form-data; charset=utf-8"), new JSONObject(map).toString());
    }
}

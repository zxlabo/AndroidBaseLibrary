package com.demo.other;


import com.bumptech.glide.util.LruCache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author : Naruto
 * date   : 2020/12/2
 * desc   :
 * version:
 */
class LruDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16,0.75f,true);
        for (int i = 0; i < 9; i++) {
            map.put(i+"00", "key"+i);
        }
        map.get("700");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

}

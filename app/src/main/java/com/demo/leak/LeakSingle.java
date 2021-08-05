package com.demo.leak;

import android.content.Context;

import java.util.ArrayList;

/**
 * author : Naruto
 * date   : 1/13/21
 * desc   :
 * version:
 */
public class LeakSingle {
    private static LeakSingle instance;
    private static Context mContext;

    public static LeakSingle getInstance(Context context) {
        mContext = context;
        if (instance==null){
            instance = new LeakSingle();
        }
        return instance;
    }

    public LeakSingle() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            strings.add("ArrayListArrayListArrayListArrayListArrayListArrayList");
        }
    }
}

package com;

import android.content.Context;
import android.util.Log;

/**
 * author : Naruto
 * date   : 2020/11/19
 * desc   :
 * version:
 */
public class MutiTest {
    public static String str;
    public static void  init(String context){
       str=context;
    }
    public static void   show(){
        if (str!=null){
//            Log.e("=-==",str);
        }
    }
}

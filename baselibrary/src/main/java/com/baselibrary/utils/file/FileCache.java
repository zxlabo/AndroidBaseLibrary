package com.baselibrary.utils.file;

import android.content.Context;
import java.io.File;


public class FileCache {
    public static File getCacheDirFile(Context context) {
        File file = new File(context.getFilesDir(), "ACache");
        return file;
    }
}

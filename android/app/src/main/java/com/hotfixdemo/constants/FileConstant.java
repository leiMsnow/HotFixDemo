package com.hotfixdemo.constants;

import android.os.Environment;

import com.hotfixdemo.MainApplication;

import java.io.File;

public class FileConstant {

    public static final String JS_BUNDLE_NAME = "index.android.bundle";

    private static final String ZIP_NAME = "js.bundle.zip";

    private static final String TEMP_FOLDER = "/temp/";

    private static final String DRAWABLE_FOLDER = "/drawable-mdpi/";

    public static final String APP_ROOT = Environment.getExternalStorageDirectory().toString()
            + File.separator + MainApplication.getInstance().getAppPackageName();

    public static final String TEMP_ROOT_PATH = APP_ROOT + TEMP_FOLDER;

    public static final String TEMP_ZIP_PATH = TEMP_ROOT_PATH + ZIP_NAME;
    public static final String TEMP_JS_BUNDLE = TEMP_ROOT_PATH + JS_BUNDLE_NAME;
    public static final String TEMP_DRAWABLE = TEMP_ROOT_PATH + DRAWABLE_FOLDER;

    public static final String LOCAL_JS_BUNDLE = APP_ROOT + File.separator + JS_BUNDLE_NAME;
    public static final String LOCAL_DRAWABLE = APP_ROOT + DRAWABLE_FOLDER;

//    public static final String JS_BUNDLE_REMOTE_URL = "http://172.12.11.216:10001/" + ZIP_NAME;
    public static final String JS_BUNDLE_REMOTE_URL = "http://10.0.0.2:10001/" + ZIP_NAME;
}

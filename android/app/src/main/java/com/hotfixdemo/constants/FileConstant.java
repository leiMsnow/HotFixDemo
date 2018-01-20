package com.hotfixdemo.constants;

import android.os.Environment;

import com.hotfixdemo.MainApplication;

import java.io.File;

public class FileConstant {

    /**
     * zip的文件名
     */
    public static final String ZIP_NAME = "JSBundle";

    public static final String JS_PATH = "/JSBundle/";

    /**
     * bundle文件名
     */
    public static final String JS_BUNDLE_LOCAL_FILE = "index.android.bundle";

    public static final String PATCH_IMG_FILE = "patch_imgs.txt";

    /**
     * 第一次解压zip后的文件目录
     */
    public static final String JS_PATCH_LOCAL_FOLDER = Environment.getExternalStorageDirectory().toString()
            + File.separator + MainApplication.getInstance().getAppPackageName();
    /**
     * 除第一次外，未来解压zip后的文件目录
     */
    public static final String FUTURE_JS_PATCH_LOCAL_FOLDER = JS_PATCH_LOCAL_FOLDER + "/future";
    public static final String FUTURE_DRAWABLE_PATH = FUTURE_JS_PATCH_LOCAL_FOLDER + JS_PATH + "drawable-xdpi/";


    public static final String LOCAL_FOLDER = JS_PATCH_LOCAL_FOLDER + File.separator + ZIP_NAME;
    public static final String DRAWABLE_PATH = JS_PATCH_LOCAL_FOLDER + JS_PATH + "drawable-xdpi/";


    public static final String FUTURE_PAT_PATH = FUTURE_JS_PATCH_LOCAL_FOLDER + JS_PATH + "bundle.pat";
    public static final String JS_PATCH_LOCAL_FILE = JS_PATCH_LOCAL_FOLDER + JS_PATH + "bundle.pat";

    /**
     * zip文件
     */
    public static final String JS_PATCH_LOCAL_PATH = LOCAL_FOLDER + File.separator + ZIP_NAME + ".zip";

    /**
     * 合并后的bundle文件保存路径
     */
    public static final String JS_BUNDLE_LOCAL_PATH = JS_PATCH_LOCAL_FOLDER + File.separator + JS_BUNDLE_LOCAL_FILE;

    /**
     * 下载URL
     */
    public static final String JS_BUNDLE_REMOTE_URL = "http://172.12.11.216:10001/" + ZIP_NAME + ".zip";
}

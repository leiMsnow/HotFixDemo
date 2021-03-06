package com.hotfixdemo;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.hotfixdemo.constants.FileConstant;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class MainApplication extends Application implements ReactApplication {

    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SoLoader.init(this, /* native exopackage */ false);
    }

    /**
     * 获取Application实例
     */
    public static MainApplication getInstance() {
        return instance;
    }

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage()
            );
        }

        @Nullable
        @Override
        protected String getJSBundleFile() {
            File file = new File(FileConstant.LOCAL_JS_BUNDLE);
            if (file.exists()) {
                Log.d("getBundleFile","'local_js_bundle'");
                return FileConstant.LOCAL_JS_BUNDLE;
            } else {
                return super.getJSBundleFile();
            }
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    public String getAppPackageName() {
        return this.getPackageName();
    }

}

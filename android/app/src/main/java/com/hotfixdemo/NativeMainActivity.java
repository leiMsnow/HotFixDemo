package com.hotfixdemo;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hotfixdemo.constants.FileConstant;
import com.hotfixdemo.hotupdate.HotUpdate;

public class NativeMainActivity extends AppCompatActivity {

    private long mDownLoadId;
    private CompleteReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver();
        checkVersion();
    }

    /**
     * 检查版本号
     */
    private void checkVersion() {
        Toast.makeText(this, "update...", Toast.LENGTH_SHORT).show();
        downloadBundle();
    }

    /**
     * 下载最新Bundle
     */
    private void downloadBundle() {

        HotUpdate.checkTempZip(getApplicationContext());

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager
                .Request(Uri.parse(FileConstant.JS_BUNDLE_REMOTE_URL));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setDestinationUri(Uri.parse("file://" + FileConstant.TEMP_ZIP_PATH));
        if (downloadManager != null)
            mDownLoadId = downloadManager.enqueue(request);
    }

    /**
     * 注册广播
     */
    private void registerReceiver() {
        localReceiver = new CompleteReceiver();
        registerReceiver(localReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    public class CompleteReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            long completeId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (completeId == mDownLoadId) {
                HotUpdate.handleZIP(getApplicationContext(), new HotUpdate.HandleCallback() {
                    @Override
                    public void handle() {
                        NativeMainActivity.this.startActivity(
                                new Intent(NativeMainActivity.this, RNMainActivity.class));
                        NativeMainActivity.this.finish();
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReceiver);
    }
}

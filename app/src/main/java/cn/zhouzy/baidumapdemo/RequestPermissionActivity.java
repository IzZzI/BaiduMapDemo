package cn.zhouzy.baidumapdemo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import java.io.File;

import butterknife.Bind;
import cn.zhouzy.baidumapdemo.base.BaseActivity;
import cn.zhouzy.baidumapdemo.util.AssetsUtils;
import cn.zhouzy.baidumapdemo.util.LogUtils;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by zhouzy on 2017-11-17
 */
@RuntimePermissions
public class RequestPermissionActivity extends BaseActivity {
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.btn_copy)
    Button btnCopy;
    @Bind(R.id.btn_open_map)
    Button btnOpenMap;
    @Bind(R.id.btn_download_map)
    Button btnDownload;
    private String assetsPath = "chengdu_75.dat";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_permission);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestPermissionActivityPermissionsDispatcher.requestPermissionWithPermissionCheck(RequestPermissionActivity.this);
            }
        });
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssetsUtils.putAssetsFileToSDCard(RequestPermissionActivity.this, assetsPath, Environment.getExternalStorageDirectory().getAbsolutePath() +
                        File.separator + "BaiduMapDemo/vmp");
            }
        });
        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RequestPermissionActivity.this, MainActivity.class);
                startActivity(in);
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestPermissionActivity.this, OfflineDemo.class);
                startActivity(intent);
            }
        });

    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void requestPermission() {
        LogUtils.e("请求权限成功");
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onPermissionDenied() {
        LogUtils.e("拒绝权限");
    }

    @OnNeverAskAgain(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onNerverAskAgain() {
        LogUtils.e("不在询问");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        RequestPermissionActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}

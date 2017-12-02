package cn.zhouzy.baidumapdemo.base;

import android.app.Application;
import android.os.Environment;

import com.baidu.mapapi.SDKInitializer;

import java.io.File;

/**
 * Created by zhouzy on 2017-10-31.
 * BaseApplication
 */

public class BaseApplication extends Application {
    private String offlineMapPath = Environment.getExternalStorageDirectory() + File.separator + "BaiduMapDemo/vmp/";
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public void init(){
        SDKInitializer.initialize(offlineMapPath, getApplicationContext());
    }

}

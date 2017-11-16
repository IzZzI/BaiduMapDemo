package cn.zhouzy.baidumapdemo.base;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by zhouzy on 2017-10-31.
 * BaseApplication
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public void init(){
        //初始化百度地图
        SDKInitializer.initialize(this);
    }

}

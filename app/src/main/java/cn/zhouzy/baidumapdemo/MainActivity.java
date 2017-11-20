package cn.zhouzy.baidumapdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.offline.MKOfflineMap;
import com.baidu.mapapi.map.offline.MKOfflineMapListener;
import com.baidu.mapapi.model.LatLng;

import java.io.File;

public class MainActivity extends Activity {
    /**
     * 百度地图View
     */
    private MapView mMapView;
    private String offlineMapPath = Environment.getExternalStorageDirectory() + File.separator + "BaiduMapDemo/vmp/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(offlineMapPath, getApplicationContext());
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.mian_mapview_map);
        MapStatus.Builder builder = new MapStatus.Builder();
        LatLng center = new LatLng(30.67, 104.06);
        builder.target(center);
        BaiduMap mBaiduMap = mMapView.getMap();
        LatLng point = new LatLng(39.963175, 116.400244);

// 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}

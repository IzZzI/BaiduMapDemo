package cn.zhouzy.baidumapdemo.util;

import android.util.Log;

/**
 * Created by zhouzy on 2017-11-16
 * 日志工具类
 */

public class LogUtils {

    /**
     * TAG
     */
    private static String TAG = "zhouzy";
    /**
     * 是否开启Debug模式
     */
    private static boolean isDebugging = true;

    /**
     * Log.e
     *
     * @param msg
     */
    public static void e(String msg) {
        if (isDebugging) {
            Log.e(TAG, msg);
        }
    }


}

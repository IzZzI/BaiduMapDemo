package cn.zhouzy.baidumapdemo.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhouzy on 2017-11-16
 */

public class AssetsUtils {

    /**
     * 获取所有文件
     *
     * @param path
     * @return
     */
    public static String[] getfilesFromAssets(Context context, String path) {
        AssetManager assetManager = context.getAssets();
        String[] files = null;
        try {
            files = assetManager.list(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LogUtils.e(e.getMessage());
        }
        for (String str : files) {
            LogUtils.e(str);
        }
        return files;
    }

    /**
     * 复制asserts文件到sd卡
     *
     * @param context
     * @param assertPath
     * @param sdCardPath
     */
    public static void putAssetsFileToSDCard(Context context, String assertPath, String sdCardPath) {
        AssetManager assetManager = context.getAssets();
        try {


            File file = new File(sdCardPath + File.separator + assertPath);
            //文件不存在
            if (!file.exists()) {
                LogUtils.e("文件不存在,复制文件到SD卡");
                if (!file.getParentFile().exists()) {
                    LogUtils.e(file.getParentFile().mkdirs() + "");
                }
                //创建文件
                file.createNewFile();
                //获取输入流
                InputStream assertInputStream = assetManager.open(assertPath);
                //获取输出流
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] b = new byte[1024];
                int len = 0;
                //读写操作
                while ((len = assertInputStream.read(b)) != -1) {
                    fileOutputStream.write(b, 0, len);
                }
                //刷新缓冲区
                fileOutputStream.flush();
                //关闭流
                fileOutputStream.close();
                assertInputStream.close();
                LogUtils.e("复制完毕");
            } else {
                //文件已存在
                LogUtils.e("文件已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.e(e.getMessage());
        }
    }

}

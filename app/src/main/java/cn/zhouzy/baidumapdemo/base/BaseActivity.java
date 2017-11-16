package cn.zhouzy.baidumapdemo.base;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;


/**
 * Created by zhouzy on 2017-10-31.
 * BaseActivity
 */

public class BaseActivity extends Activity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}

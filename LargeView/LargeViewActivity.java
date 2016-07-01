package com.xytxw.viewstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.xytxw.viewstudy.R;
import com.xytxw.viewstudy.view.LargeView;

import java.lang.reflect.Field;

/**
 * Created by yupu on 2016/7/1-10:52.
 * Email:459112332@qq.com
 */
public class LargeViewActivity extends AppCompatActivity {
    private LargeView largeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_view);
        largeView = (LargeView) findViewById(R.id.id_large_view);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change) {
            int height=getSupportActionBar().getHeight();
            largeView.setPhoto(height);
        }
        return super.onOptionsItemSelected(item);
    }
    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            Logger.d("get status bar height fail");
            e1.printStackTrace();
            return 75;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_change, menu);
        return true;
    }
}

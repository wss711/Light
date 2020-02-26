package com.gr.light.advanceview.toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.palette.graphics.Palette;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import butterknife.BindView;

public class WssToolbarActivity extends BaseActivity {

    @BindView(R.id.light_toolbar)
    Toolbar lightToolbar;
    @BindView(R.id.content_interface_ll)
    LinearLayout contentInterfaceLl;
    @BindView(R.id.close_side_tv)
    TextView closeSideTv;
    @BindView(R.id.side_interface_ll)
    LinearLayout sideInterfaceLl;
    @BindView(R.id.toolbar_drawerlayout)
    DrawerLayout toolbarDrawerlayout;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Light","Toolbar onCreate");
        initViews();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wss_toolbar;
    }

    private void initViews(){
        lightToolbar.setTitle("  Light Toolbar");
        setSupportActionBar(lightToolbar);

        //是否给左上角图标的左边加上一个返回的图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.toolbarlogo);

        lightToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(WssToolbarActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(WssToolbarActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        //设置侧或布局
        mDrawerToggle = new ActionBarDrawerToggle(this,toolbarDrawerlayout,lightToolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();
        toolbarDrawerlayout.addDrawerListener(mDrawerToggle);
        closeSideTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarDrawerlayout.closeDrawer(Gravity.LEFT);
            }
        });

        setPatette();

    }

    private void setPatette() {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.bitmap);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch=palette.getVibrantSwatch();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(swatch.getRgb()));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menuz_write; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

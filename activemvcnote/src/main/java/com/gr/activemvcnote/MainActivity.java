package com.gr.activemvcnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.gr.activemvcnote.fragment.DiaryFragment;
import com.gr.activemvcnote.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initFragment();
    }

    /**
     * TODO 初始化工具栏
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-02-29 16:23
     **/
    private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * TODO 初始化Fragment
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-02-29 16:23
     **/
    private void initFragment(){
        // 创建日记Fragment
        DiaryFragment diaryFragment = getDiaryFragment();
        if(diaryFragment == null){
            diaryFragment = new DiaryFragment();
            // 将日记Fragment添加到Activity显示
            ActivityUtils.addFragment2Activity(getSupportFragmentManager(),diaryFragment,R.id.content);
        }
    }
    private DiaryFragment getDiaryFragment(){
        return (DiaryFragment)getSupportFragmentManager().findFragmentById(R.id.content);
    }

}

package com.gr.mvpclean.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gr.mvpclean.R;
import com.gr.mvpclean.activity.fragment.adapter.DiaryAdapter;
import com.gr.mvpclean.contract.DiaryContract;
import com.gr.mvpclean.edit.DiaryEditActivity;
import com.gr.mvpclean.edit.DiaryEditFragment;
import com.gr.mvpclean.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-22
 **/
public class DiaryFragment extends Fragment implements DiaryContract.View{

    private DiaryContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //  加载布局
        View root = inflater.inflate(R.layout.fragment_diaries,container,false);
        this.mRecyclerView = root.findViewById(R.id.diaries_list); // 传入RecyclerView控件

        // 将日记列表控件传入控制器
        initDiaryList();

        // 设置界面有菜单功能
        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void gotoWriteDiary() {
        Intent intent = new Intent(getContext(), DiaryEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotoUpdateDiary(String diaryId) {
        Intent intent = new Intent(getContext(),DiaryEditActivity.class);
        intent.putExtra(DiaryEditFragment.DIARY_ID,diaryId);
        getContext().startActivity(intent);
    }

    @Override
    public void showSuccess() {
        showMessage(getString(R.string.success));
    }

    @Override
    public void showError() {
        showMessage(getString(R.string.error)); // 弹出失败提示信息
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setAdapter(DiaryAdapter diaryAdapter) {
        mRecyclerView.setAdapter(diaryAdapter);
    }

    @Override
    public void setPresenter(DiaryContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) { // 创建菜单，重写父类中的方法
        inflater.inflate(R.menu.menu_write, menu); // 加载菜单的布局文件
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 菜单的选择监听，重写父类中的方法
        switch (item.getItemId()) { // 判断点击事件
            case R.id.menu_add: // 点击添加按钮
                mPresenter.addDiary(); // 通知控制器添加新的日记
                return true; // 返回true代表菜单点选择事件已经被处理
        }
        return false; // 返回false代表菜单点选择事件没有被处理
    }


    /**
     * 配置日记列表
     * */
    public void initDiaryList(){

        // 设置日记列表为线性布局表示
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // 为列表条目添加分割线
        mRecyclerView.addItemDecoration( new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        // 设置列表默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show(); // 弹出文字提示信息
    }
}

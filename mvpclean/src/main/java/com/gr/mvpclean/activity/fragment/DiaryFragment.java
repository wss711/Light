package com.gr.mvpclean.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public void gotoUpdateDiary() {
        Intent intent = new Intent(getContext(),DiaryEditActivity.class);
        intent.putExtra(Dia)
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setAdapter(DiaryAdapter diaryAdapter) {

    }

    @Override
    public void setPresenter(DiaryContract.Presenter presenter) {

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
}

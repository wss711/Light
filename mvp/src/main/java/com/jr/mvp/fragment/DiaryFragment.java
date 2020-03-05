package com.jr.mvp.fragment;

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

import com.jr.mvp.R;
import com.jr.mvp.edit.DiaryEditActivity;
import com.jr.mvp.edit.DiaryEditFragment;
import com.jr.mvp.main.DiaryContract;
import com.jr.mvp.main.list.DiaryAdapter;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-05
 **/
public class DiaryFragment extends Fragment implements DiaryContract.View {

    private DiaryContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary,container,false);
        this.mRecyclerView = view.findViewById(R.id.diary_list_rv);
        // 导入日记列表控件
        initDiaryList();
        // 加入菜单功能
        setHasOptionsMenu(true);

        return view;
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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_write,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                mPresenter.addDiary();
                return true;
        }
        return false;
    }

    /** 跳转添加日记 */
    @Override
    public void gotoWriteDiary() {
        Intent intent = new Intent(getContext(), DiaryEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotoUpdateDiary(String diaryId) {
        Intent intent = new Intent(getContext(),DiaryEditActivity.class);
        intent.putExtra(DiaryEditFragment.DIARY_ID,diaryId);
    }

    @Override
    public void showSuccess() {
        showMessage(getString(R.string.success));
    }

    @Override
    public void showError() {
        showMessage(getString(R.string.error));
    }

    @Override
    public boolean isActive() {
        return isAdded(); // 判断Fragment是否已经添加到了Activity中
    }

    @Override
    public void setListAdapter(DiaryAdapter mListAdapter) {
        mRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void setPresenter(DiaryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private void showMessage(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show(); // 弹出文字提示信息
    }
    private void initDiaryList(){
        // 设置日记列表为线性布局显示
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // 为列表条目添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        // 设置列
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}

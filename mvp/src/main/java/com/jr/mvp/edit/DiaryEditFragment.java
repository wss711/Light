package com.jr.mvp.edit;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jr.mvp.R;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-05
 **/
public class DiaryEditFragment extends Fragment implements DiaryEditContract.View {

    public static final String DIARY_ID = "diary_list" ;
    private DiaryEditContract.Presenter mPresenter;
    private TextView mTitle;
    private TextView mDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary_edit,container,false);
        mTitle = view.findViewById(R.id.edit_title);
        mDescription = view.findViewById(R.id.edit_description);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onDestroy() {
        mPresenter.unSubscribe();
        super.onDestroy();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_done,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_done:
                mPresenter.saveDiary(mTitle.getText().toString(),mDescription.getText().toString());
                return true;
        }
        return false;
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(),getString(R.string.error),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDiaryList() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void setDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(DiaryEditContract.Presenter presenter) {
        mPresenter = presenter;
    }

}

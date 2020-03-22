package com.gr.mvpclean.base;

import com.gr.mvpclean.utils.ThreadUtils;

/**
 * TODO UI线程切换处理包装类
 * <p>
 * Created by WSS on  2020-03-21
 **/
public class UICallbackWrapper<P> implements UseCase.UseCaseCallback<P> {

    private final UseCase.UseCaseCallback<P> mCallback;

    public UICallbackWrapper(UseCase.UseCaseCallback<P> callback) {
        this.mCallback = callback;
    }

    @Override
    public void onSuccess(P response) {
        ThreadUtils.runOnUI(() -> {mCallback.onSuccess(response);});
    }

    @Override
    public void onError() {
        ThreadUtils.runOnUI(mCallback::onError);
    }
}

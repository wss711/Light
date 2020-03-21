package com.gr.mvpclean.base;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-20
 **/
public abstract class UseCase<Q,P> {

    private Q mRequestValues;
    private UseCaseCallback<P> mUseCaseCallback;

    public UseCase<Q,P> setRequestValues(Q requestValues){
        this.mRequestValues = requestValues;
        return this;
    }

    public Q getRequestValues(){
        return mRequestValues;
    }

    public UseCaseCallback<P> getUseCaseCallback(){
        return mUseCaseCallback;
    }

    /** 数据处理结束后的回调 */
    public UseCase<Q,P> setUseCaseCallback(UseCaseCallback<P> useCaseCallback){
        this.mUseCaseCallback = new UICallbackWrapper<>(useCaseCallback);
        return this;
    }

    /** 任意线程，callback返回主线程 */
    public void run(){
        executeUseCase(mRequestValues);
    }

    /** 处理数据 */
    protected abstract void executeUseCase(Q requestValues);

    /** 请求数据接口，若有多个，需要封装出入 */
    public interface RequestValues {

    }


    /** 响应数据接口，若有多个，需要封装传出 */
    public interface ResponseValues {

    }

    /**
     * 若返回数据包含多个，需要封装传入
     * */
    public interface UseCaseCallback<P> {

        void onSuccess(P response);

        void onError();
    }

}



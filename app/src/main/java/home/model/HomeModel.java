package home.model;

import java.util.List;

import home.bean.HomeBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.API;
import utils.ApiServer;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class HomeModel implements Imodel {
    private OnFinishLisenter lisenter;
    //定义接口
    public interface OnFinishLisenter{
        void onFinish(HomeBean userBean);
    }
    public void setOnFinishLisenter(OnFinishLisenter lisenter){
        this.lisenter = lisenter;
    }
    @Override
    public void geturl(String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.HOME_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiser = retrofit.create(ApiServer.class);
        Observable<HomeBean> gethom = apiser.getHome();
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean dataBean) {
                        lisenter.onFinish(dataBean);
                    }
                });
    }
}

package mine.model;

import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import mine.bean.LoginBean;
import mine.bean.ZhuceBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.API;
import utils.ApiServer;
import utils.Myapp;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class Minemodel implements  IMineModel {

    private Minemodel.OnFinishLisenter lisenter;
    //定义接口
    public interface OnFinishLisenter{
        void onFinish(LoginBean userBean);
    }
    public void setOnFinishLisenter(Minemodel.OnFinishLisenter lisenter){
        this.lisenter = lisenter;
    }


    private Minemodel.OnFinishLisenters lisenters;
    //定义接口
    public interface OnFinishLisenters{
        void onFinishs(ZhuceBean userBean);
    }
    public void setOnFinishLisenters(Minemodel.OnFinishLisenters lisenters){
        this.lisenters = lisenters;
    }
    @Override
    public void getuser(String url,String phone, String pass) {
//        Toast.makeText(Myapp.context,"网络请求",Toast.LENGTH_SHORT).show();
        Map map=new HashMap<String,String>();
        map.put("mobile",phone);
        map.put("password",pass);
        map.put("key","login");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.LOGIN_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiser = retrofit.create(ApiServer.class);
        Observable<LoginBean> gethom = apiser.getuser(url,map);
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(Myapp.context,"错误",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        lisenter.onFinish(loginBean);
//                        Toast.makeText(Myapp.context,loginBean.getCode(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void getzhucecode(String url,String phone, String pass) {
//        Toast.makeText(Myapp.context,"网络请求",Toast.LENGTH_SHORT).show();
        Map map=new HashMap<String,String>();
        map.put("mobile",phone);
        map.put("password",pass);
        map.put("key","reg");
        Toast.makeText(Myapp.context,map+"",Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.REG_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiser = retrofit.create(ApiServer.class);
        Observable<ZhuceBean> gethom = apiser.getzhucecode(url,map);
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(Myapp.context,"错误",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ZhuceBean zhuceBean) {
                        lisenters.onFinishs(zhuceBean);
                    }


                });
    }

}

package sort.model;

import home.bean.HomeBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sort.bean.DataleftBean;
import sort.bean.DatarightBean;
import sort.bean.DateGridBean;
import utils.API;
import utils.ApiServer;
import utils.RetroSort;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public class SortMymodel implements ISortmodel {

    SetDate setDate;
    public SortMymodel(SetDate setDate) {
        this.setDate = setDate;
    }

    public interface  SetDate{
        void getleftdate(DataleftBean dataleftBean);
        void getrightdate(DatarightBean datarightBean);
        void getgrifdate(DateGridBean dateGridBean);
    }


    @Override
    public void getServerkleft() {

        Observable<DataleftBean> gethom =new RetroSort().getInstance().getsortleft();
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataleftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DataleftBean dataleftBean) {
                        setDate.getleftdate(dataleftBean);
                    }

                });

    }

    @Override
    public void getSerberkright(String gc_id, int position) {
        Observable<DatarightBean> gethom =new RetroSort().getInstance().getsortright(gc_id);
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DatarightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DatarightBean datarightBean) {
                        setDate.getrightdate(datarightBean);
                    }
                });
    }

    @Override
    public void getservergird() {
        Observable<DateGridBean> gethom =new RetroSort().getInstance().getsortgrid();
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DateGridBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DateGridBean dateGridBean) {
                        setDate.getgrifdate(dateGridBean);
                    }


                });

    }
}

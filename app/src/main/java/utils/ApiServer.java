package utils;

import java.util.Map;

import home.bean.HomeBean;
import mine.bean.LoginBean;
import mine.bean.ZhuceBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public interface ApiServer {
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();

    @POST
    Observable<LoginBean> getuser(@Url String url, @QueryMap Map<String,String> map);
    @POST
    Observable<ZhuceBean> getzhucecode(@Url String url, @QueryMap Map<String,String> map);
}

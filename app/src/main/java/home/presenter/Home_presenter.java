package home.presenter;

import home.bean.HomeBean;
import home.model.HomeModel;
import home.view.Iview;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class Home_presenter implements HomeModel.OnFinishLisenter{

    private Iview iview;
    private  HomeModel mymodel;

    public Home_presenter(Iview iview) {
        this.iview = iview;
        this.mymodel = new HomeModel();
    }
    public   void  setadapter(String path){
        mymodel.setOnFinishLisenter(this);
        mymodel.geturl(path);

    }
    @Override
    public void onFinish(HomeBean userBean) {
        iview.getdata(userBean);
    }
}

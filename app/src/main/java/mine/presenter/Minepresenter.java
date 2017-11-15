package mine.presenter;

import mine.bean.LoginBean;
import mine.bean.ZhuceBean;
import mine.model.Minemodel;
import mine.view.IMineview;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class Minepresenter implements Minemodel.OnFinishLisenter,Minemodel.OnFinishLisenters {
    private IMineview imineview;
    private Minemodel minemodel;

    public Minepresenter(IMineview iMineview) {
        this.imineview = iMineview;
        this.minemodel = new Minemodel();
    }

    public   void setuser(String url,String name,String pass){
//        Toast.makeText(Myapp.context,"回调",Toast.LENGTH_SHORT).show();
        minemodel.setOnFinishLisenter(this);
        minemodel.getuser(url,name,pass);
    }
    public   void setcode(String url,String name,String pass){
//        Toast.makeText(Myapp.context,"回调",Toast.LENGTH_SHORT).show();
        minemodel.setOnFinishLisenters(this);
        minemodel.getzhucecode(url,name,pass);
//        Toast.makeText(Myapp.context,"传值",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFinish(LoginBean userBean) {
        imineview.getcode(userBean.getCode());
    }

    @Override
    public void onFinishs(ZhuceBean userBean) {
        imineview.getzhucecode(userBean.getCode());
//        Toast.makeText(Myapp.context,"回调",Toast.LENGTH_SHORT).show();
    }
}

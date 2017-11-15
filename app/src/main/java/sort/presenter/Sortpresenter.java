package sort.presenter;

import sort.bean.DataleftBean;
import sort.bean.DatarightBean;
import sort.bean.DateGridBean;
import sort.model.SortMymodel;
import sort.view.Isortview;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public class Sortpresenter implements SortMymodel.SetDate {
    private Isortview isortview;
    private SortMymodel sortMymodel;

    public Sortpresenter(Isortview isortview) {
        this.isortview = isortview;
        this.sortMymodel = new SortMymodel(this);
    }
    public void leftdate(){
        sortMymodel.getServerkleft();
    }
    public void rightdate(String id,int position){
        sortMymodel.getSerberkright(id,position);
    }
    public void griddate(){
        sortMymodel.getservergird();
    }
    @Override
    public void getleftdate(DataleftBean dataleftBean) {
        isortview.getleft(dataleftBean);
    }

    @Override
    public void getrightdate(DatarightBean datarightBean) {
        isortview.getright(datarightBean);
    }

    @Override
    public void getgrifdate(DateGridBean dateGridBean) {
        isortview.getgird(dateGridBean);
    }
}

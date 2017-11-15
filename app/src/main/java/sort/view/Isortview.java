package sort.view;

import sort.bean.DataleftBean;
import sort.bean.DatarightBean;
import sort.bean.DateGridBean;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public interface Isortview {
    void getleft(DataleftBean dataleftBean);
    void getright(DatarightBean datarightBean);
    void getgird(DateGridBean dateGridBean);
}

package home.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.manshop_app.R;
import com.facebook.drawee.view.SimpleDraweeView;

import home.bean.HomeBean;

import static com.example.administrator.manshop_app.R.id.home_img;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class ViewCadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    HomeBean DataBean;

    public ViewCadapter(Context context, HomeBean DataBean) {
        this.context = context;
        this.DataBean = DataBean;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_home,parent,false);
        ViewHolder holder= new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String img=DataBean.getData().getActivityInfo().getActivityInfoList().get(position%2).getActivityImg();
        Uri uri = Uri.parse(img);
        ((ViewHolder)holder).home_img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return DataBean.getData().getActivityInfo().getActivityInfoList().size()*2;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView home_img;

        public ViewHolder(View itemView) {
            super(itemView);
            home_img=(SimpleDraweeView) itemView.findViewById(R.id.home_img);
        }
    }
}

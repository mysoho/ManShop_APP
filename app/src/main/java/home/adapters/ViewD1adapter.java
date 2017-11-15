package home.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.manshop_app.R;
import com.facebook.drawee.view.SimpleDraweeView;

import home.bean.HomeBean;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class ViewD1adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
   HomeBean DataBean;

    public ViewD1adapter(Context context, HomeBean DataBean) {
        this.context = context;
        this.DataBean = DataBean;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.homesshow,parent,false);
        ViewD1adapter.ViewHolder viewholder=new ViewD1adapter.ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String imgs=DataBean.getData().getSubjects().get(1).getGoodsList().get(position).getGoodsImage();
//        loader.displayImage(imgs,((ViewD1adapter.ViewHolder)holder).imgs);
        Uri uri = Uri.parse(imgs);

        ((ViewD1adapter.ViewHolder)holder).imgs.setImageURI(uri);
        ((ViewD1adapter.ViewHolder)holder).tvs.setText(DataBean.getData().getSubjects().get(1).getGoodsList().get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return DataBean.getData().getSubjects().get(1).getGoodsList().size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView imgs;
        TextView tvs;
        public ViewHolder(View itemView) {
            super(itemView);
            imgs=(SimpleDraweeView) itemView.findViewById(R.id.imgs);
            tvs=(TextView) itemView.findViewById(R.id.tvs);
        }
    }
}

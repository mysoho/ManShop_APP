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

public class ViewEadapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    HomeBean DataBean;

    public ViewEadapter(Context context, HomeBean DataBean ) {
        this.context = context;
        this.DataBean = DataBean;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_ends,parent,false);
        ViewEadapter.ViewHolder viewholder=new ViewEadapter.ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        String imgs = DataBean.getData().getDefaultGoodsList().get(position).getGoods_img();
//        loader.displayImage(imgs, ((ViewEadapter.ViewHolder) holder).imgs);
        ((ViewEadapter.ViewHolder) holder).tvs.setText(DataBean.getData().getDefaultGoodsList().get(position).getGoods_name());
        Uri uri = Uri.parse(imgs);

        ((ViewEadapter.ViewHolder) holder).imgs.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return DataBean.getData().getDefaultGoodsList().size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgs;
        TextView tvs;
        public ViewHolder(View itemView) {
            super(itemView);
            imgs=(ImageView) itemView.findViewById(R.id.imgs);
            tvs=(TextView) itemView.findViewById(R.id.tvs);
        }
    }
}

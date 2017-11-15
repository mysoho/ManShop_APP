package home.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.manshop_app.R;
import com.facebook.drawee.view.SimpleDraweeView;

import home.bean.HomeBean;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class ViewBadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    HomeBean DataBean;

    public ViewBadapter(Context context, HomeBean DataBean ) {
        this.context = context;
        this.DataBean = DataBean;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_home_end,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).text.setText(DataBean.getData().getAd5().get(position).getTitle());
        String img=DataBean.getData().getAd5().get(position).getImage();
        Uri uri = Uri.parse(img);

        ((ViewHolder) holder).img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return DataBean.getData().getAd5().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView img;
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            img=(SimpleDraweeView) itemView.findViewById(R.id.img);
            text=(TextView) itemView.findViewById(R.id.tv);
        }
    }
}

package home.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.manshop_app.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;
import home.bean.GlideImaGlideImageLoader;
import home.bean.HomeBean;

import static com.example.administrator.manshop_app.R.id.id_recyclerview;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    HomeBean dataBean;
    ArrayList mlist;
    Handler handler;
    Runnable runnable;

    ViewBadapter viewBadapterl;
    ViewCadapter viewBadapter2;
    ViewDadapter viewBadapter3;
    ViewD1adapter viewBadapter4;
    ViewEadapter viewBadapter5;
    private  long  time=400;

    public HomeAdapter(Context context, HomeBean dataBean) {
        this.context = context;
        this.dataBean = dataBean;

    }
    public enum  Item_Type{
        TYPEone,TYPEtwo,TYPEthree,TYPEfour,TYPEfive
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType==Item_Type.TYPEone.ordinal()){
            View view= LayoutInflater.from(context).inflate(R.layout.banner1,parent,false);
            ViewHolderA viewHolder=new ViewHolderA(view);
            return  viewHolder;
        }else if(viewType==Item_Type.TYPEtwo.ordinal()){
            View view= LayoutInflater.from(context).inflate(R.layout.home_1,parent,false);
            ViewHolderB viewHolder=new ViewHolderB(view);

            return  viewHolder;
        } else if(viewType==Item_Type.TYPEthree.ordinal()){
            View view= LayoutInflater.from(context).inflate(R.layout.recycler,parent,false);
            ViewHolderC viewHolder=new ViewHolderC(view);
            return  viewHolder;
        } else if(viewType==Item_Type.TYPEfour.ordinal()){
            View view= LayoutInflater.from(context).inflate(R.layout.recycler_real,parent,false);
            ViewHolderD viewHolder=new ViewHolderD(view);
            return  viewHolder;
        }else if(viewType==Item_Type.TYPEfive.ordinal()){
            View view= LayoutInflater.from(context).inflate(R.layout.recyclers,parent,false);
            ViewHolderE viewHolder=new ViewHolderE(view);
            return  viewHolder;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderA) {
            mlist=new ArrayList();
            for(int i=0;i<dataBean.getData().getAd1().size();i++){
                mlist.add(dataBean.getData().getAd1().get(i).getImage());
            }
            ((ViewHolderA) holder).mbanner.setImageLoader(new GlideImaGlideImageLoader());
            ((ViewHolderA) holder).mbanner.setImages(mlist);
            ((ViewHolderA) holder).mbanner.start();

        }else if (holder instanceof ViewHolderB) {
          /*  LinearLayoutManager layoutManager=new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
            GridLayoutManager layoutManager=new GridLayoutManager(context,4);
            ((ViewHolderB) holder).recyclerView.setLayoutManager(layoutManager);
            viewBadapterl=new ViewBadapter(context,dataBean);
            ((ViewHolderB) holder).recyclerView.setAdapter(viewBadapterl);
            ((ViewHolderB) holder).teacher_countdownView.start(100000000);
        } else if (holder instanceof ViewHolderC) {
            StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
            ((ViewHolderC) holder).id_recyclerview.setLayoutManager(layoutManager);
            viewBadapter2=new ViewCadapter(context,dataBean);
            ((ViewHolderC) holder).id_recyclerview.setAdapter(viewBadapter2);
            String img=dataBean.getData().getSubjects().get(0).getImage();

            Uri uri = Uri.parse(img);

            ((ViewHolderC) holder).xiran.setImageURI(uri);
        } else if (holder instanceof ViewHolderD) {
            StaggeredGridLayoutManager layoutManagers=new StaggeredGridLayoutManager(1,LinearLayoutManager.HORIZONTAL);
            StaggeredGridLayoutManager layoutManagers2=new StaggeredGridLayoutManager(1,LinearLayoutManager.HORIZONTAL);
            ((ViewHolderD) holder).recyclerviews.setLayoutManager(layoutManagers);
            ((ViewHolderD) holder).recyclerviewss.setLayoutManager(layoutManagers2);
            viewBadapter3=new ViewDadapter(context,dataBean);
            viewBadapter4=new ViewD1adapter(context,dataBean);
            ((ViewHolderD) holder).recyclerviews.setAdapter(viewBadapter3);
            ((ViewHolderD) holder).recyclerviewss.setAdapter(viewBadapter4);
            String img_real=dataBean.getData().getSubjects().get(1).getImage();

            Uri uri = Uri.parse(img_real);

            ((ViewHolderD) holder).img_real.setImageURI(uri);
        }else if (holder instanceof ViewHolderE) {
            StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
            ((ViewHolderE) holder).recyclers.setLayoutManager(layoutManager);
            viewBadapter5=new ViewEadapter(context,dataBean);
            ((ViewHolderE) holder).recyclers.setAdapter(viewBadapter5);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return Item_Type.TYPEone.ordinal();
        }else if(position==1){
            return Item_Type.TYPEtwo.ordinal();
        }else if(position==2){
            return Item_Type.TYPEthree.ordinal();
        }else if(position==3){
            return Item_Type.TYPEfour.ordinal();
        }else if(position==4){
            return Item_Type.TYPEfive.ordinal();
        }
        return -1;
    }



    class ViewHolderA extends RecyclerView.ViewHolder {
        public Banner mbanner;

        public ViewHolderA(View itemView) {
            super(itemView);

            mbanner = (Banner) itemView.findViewById(R.id.mybanner);
        }
    }



    class ViewHolderB extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        CountdownView teacher_countdownView;

        public ViewHolderB(View itemView) {
            super(itemView);
            recyclerView=(RecyclerView) itemView.findViewById(id_recyclerview);
            teacher_countdownView=(CountdownView) itemView.findViewById(R.id.teacher_countdownView);


        }


    }

    class ViewHolderC extends RecyclerView.ViewHolder {

        RecyclerView id_recyclerview;
        SimpleDraweeView xiran;
        public ViewHolderC(View itemView) {
            super(itemView);
            id_recyclerview=(RecyclerView) itemView.findViewById(R.id.id_recyclerview);
            xiran=(SimpleDraweeView) itemView.findViewById(R.id.xiran);
        }
    }
    class ViewHolderD extends RecyclerView.ViewHolder {

        RecyclerView recyclerviews,recyclerviewss;
        SimpleDraweeView img_real;
        public ViewHolderD(View itemView) {
            super(itemView);
            recyclerviews=(RecyclerView) itemView.findViewById(R.id.recyclerviews);
            recyclerviewss=(RecyclerView) itemView.findViewById(R.id.recyclerviewss);
            img_real=(SimpleDraweeView) itemView.findViewById(R.id.img_real);
        }
    }
    class ViewHolderE extends RecyclerView.ViewHolder {

        RecyclerView recyclers;
        public ViewHolderE(View itemView) {
            super(itemView);
            recyclers=(RecyclerView) itemView.findViewById(R.id.recyclers);
        }
    }

}

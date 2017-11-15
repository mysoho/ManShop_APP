package home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.manshop_app.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import home.adapters.HomeAdapter;
import home.bean.HomeBean;
import home.presenter.Home_presenter;
import home.view.Iview;
import utils.API;

import static android.R.id.list;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class Fragment_Home  extends Fragment implements Iview{
    private XRecyclerView xrecyclerview;
    List<HomeBean> list;
    HomeAdapter adapter;
    Home_presenter mypre;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_home,container,false);
        xrecyclerview = (XRecyclerView)view.findViewById(R.id.xrecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list=new ArrayList<HomeBean>();
        xrecyclerview.setLayoutManager(layoutManager);

        mypre=new Home_presenter(this);

        mypre.setadapter(API.HOME_URL);
        return view;
    }

    @Override
    public void getdata(HomeBean data) {
        adapter = new HomeAdapter(getActivity(), data);
        xrecyclerview.setAdapter(adapter);
        xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                adapter.notifyDataSetChanged();
                xrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {

                adapter.notifyDataSetChanged();
                xrecyclerview.loadMoreComplete();

            }
        });
    }
}

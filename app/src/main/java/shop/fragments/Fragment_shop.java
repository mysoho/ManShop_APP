package shop.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.manshop_app.R;

import mine.activitys.Login_Activity;
import mine.bean.SPUtils;
import utils.Myapp;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class Fragment_shop extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String info_login= (String) SPUtils.get(Myapp.context,"info_login","false");
        if(info_login.equals("false")){
            Intent intent=new Intent();
            intent.setClass(getActivity(), Login_Activity.class);
            startActivity(intent);
        }
        View view=inflater.inflate(R.layout.frag_shop,container,false);

        return view;
    }



}

package mine.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.manshop_app.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mine.activitys.Login_Activity;
import mine.bean.MessageEvent;
import mine.bean.SPUtils;
import utils.Myapp;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class Fragment_mine extends Fragment {
    @BindView(R.id.userimg)
    ImageView userimg;
    @BindView(R.id.user_name)
    TextView username;
    @BindView(R.id.layout1)
    LinearLayout layout1;
    @BindView(R.id.layout2)
    LinearLayout layout2;
    @BindView(R.id.layout3)
    LinearLayout layout3;
    @BindView(R.id.layout4)
    LinearLayout layout4;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String info_login= (String) SPUtils.get(Myapp.context,"info_login","false");
        if(info_login.equals("false")){
            Intent intent=new Intent();
            intent.setClass(getActivity(), Login_Activity.class);
            startActivity(intent);
        }
        View view = inflater.inflate(R.layout.frag_me, container, false);
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent) {
        username.setText(messageEvent.getMessage());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}


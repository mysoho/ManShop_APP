package mine.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.manshop_app.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mine.bean.MessageEvent;
import mine.bean.SPUtils;
import mine.presenter.Minepresenter;
import mine.view.IMineview;
import utils.Myapp;

public class Login_Activity extends AppCompatActivity implements IMineview {


    Minepresenter mypre;
    String mpath = "http://120.27.23.105/user/login";
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.activity_login_)
    RelativeLayout activityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        ButterKnife.bind(this);
        mypre = new Minepresenter(this);
        SPUtils.put(Myapp.context,"info_login","false");

    }

    @Override
    public void getcode(String code) {
        if (code.equals("0")) {
            String names = username.getText().toString().trim();
            EventBus.getDefault().post(new MessageEvent(names));
            SPUtils.put(Myapp.context,"info_login","true");
            Toast.makeText(Login_Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
            SPUtils.put(Myapp.context,"code",0);
            finish();
        } else if (code.equals("1")) {
            SPUtils.put(Myapp.context,"info_login","false");
            Toast.makeText(Login_Activity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getzhucecode(String code) {

    }


    @OnClick({R.id.zhuce, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                Intent intent=new Intent();
                intent.setClass(Login_Activity.this,ZhuceActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                mypre.setuser(mpath, name, pass);
                break;
        }
    }




}

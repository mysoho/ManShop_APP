package mine.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.manshop_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mine.presenter.Minepresenter;
import mine.view.IMineview;
import utils.Myapp;

public class ZhuceActivity extends AppCompatActivity implements IMineview{

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.surepass)
    EditText surepass;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.zhuce)
    Button zhuce;
    @BindView(R.id.activity_zhuce)
    RelativeLayout activityZhuce;
    Minepresenter mypre;
    String mpath = "http://120.27.23.105/user/reg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
       mypre=new Minepresenter(this);

    }

    @OnClick(R.id.zhuce)
    public void onViewClicked() {
        String username = name.getText().toString().trim();
        String password = pass.getText().toString().trim();
        Toast.makeText(Myapp.context,username+"---"+password,Toast.LENGTH_SHORT).show();
        mypre.setcode(mpath, username, password);
    }


    @Override
    public void getcode(String code) {

    }

    @Override
    public void getzhucecode(String code) {
        Toast.makeText(Myapp.context,code,Toast.LENGTH_SHORT).show();
        if (code.equals("0")){
            Toast.makeText(ZhuceActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            Intent i=new Intent();
            i.setClass(ZhuceActivity.this,Login_Activity.class);
            startActivity(i);
        }else if(code.equals("1")){
            Toast.makeText(ZhuceActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
        }
    }
}

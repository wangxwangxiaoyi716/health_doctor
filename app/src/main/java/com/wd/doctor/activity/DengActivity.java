package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.contract.LoginContract;
import com.wd.doctor.presenter.LoginPresenter;
import com.wd.doctor.utils.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {
    public static final String TAG = "DengActivity";
    @BindView(R.id.emil_img)
    SimpleDraweeView emilImg;
    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.pwd_img)
    SimpleDraweeView pwdImg;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.wjmm)
    TextView wjmm;
    @BindView(R.id.shenqing_ruzhu)
    TextView shenqingRuzhu;
    @BindView(R.id.but_denglu)
    Button butDenglu;
    @BindView(R.id.togg_log_eye)
    ToggleButton toggLogEye;
    private String s;
    private SharedPreferences sp;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_deng;
    }

    @Override
    protected void initData() {
        super.initData();

        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);

        edPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//默认为隐藏
        toggLogEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //判断事件源的选中状态
                if (isChecked) {
                    //显示密码
                    edPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggLogEye.setBackgroundResource(R.mipmap.login_icon_show_password);//选中时显示的图标
                } else {
                    //设置转换方法
                    edPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggLogEye.setBackgroundResource(R.mipmap.login_icon_hide_password_n);//选中时隐藏的图标
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                edPwd.setSelection(edPwd.length());//设置选择
            }
        });
    }




    @Override
    public void onDengSuccess(LoginBean loginBean) {
        Log.d(TAG, "onDengSuccess: " + loginBean.getMessage());
        if ("0000".equals(loginBean.getStatus())) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DengActivity.this, HomeActivity.class);
            SharedPreferences.Editor edit = sp.edit();
            edit.putInt("id",loginBean.getResult().getId());
            edit.putString("s",loginBean.getResult().getSessionId());
            edit.commit();
            startActivity(intent);

        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoginFiluse(String e) {
        Log.d(TAG, "onLoginFiluse: " + e);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.wjmm, R.id.shenqing_ruzhu, R.id.but_denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wjmm:
                Intent intent1 = new Intent(DengActivity.this, WangJiActivity.class);
                startActivity(intent1);
                break;
            case R.id.shenqing_ruzhu:
                Intent intent = new Intent(DengActivity.this, RuZhuActivity.class);
                startActivity(intent);
                break;
            case R.id.but_denglu:
                String email = edEmail.getText().toString();
                String pwd = edPwd.getText().toString();

                if(email.isEmpty()||pwd.isEmpty())
                {
                    Toast.makeText(this, "邮箱密码不可以为空", Toast.LENGTH_SHORT).show();
                } else
                {
                    try {
                        s = RsaCoder.encryptByPublicKey(pwd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mpresenter.onDengPresenter(email, s);
                    Log.d(TAG, "onViewClicked: " + email + s);
                }
                break;
        }
    }
}

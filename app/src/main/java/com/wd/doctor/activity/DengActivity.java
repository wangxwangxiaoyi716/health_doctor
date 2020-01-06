package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.wd.doctor.R2;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.contract.LoginContract;
import com.wd.doctor.presenter.LoginPresenter;
import com.wd.doctor.utils.RsaCoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class DengActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {
    public static final String TAG = "DengActivity";
    @BindView(R2.id.emil_img)
    SimpleDraweeView emilImg;
    @BindView(R2.id.ed_email)
    EditText edEmail;
    @BindView(R2.id.pwd_img)
    SimpleDraweeView pwdImg;
    @BindView(R2.id.ed_pwd)
    EditText edPwd;
    @BindView(R2.id.wjmm)
    TextView wjmm;
    @BindView(R2.id.shenqing_ruzhu)
    TextView shenqingRuzhu;
    @BindView(R2.id.but_denglu)
    Button butDenglu;
    @BindView(R2.id.togg_log_eye)
    ToggleButton toggLogEye;
    private String s;
    private SharedPreferences sp;
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private String email;
    private String pwd;
    private String userName;
    private String jiGuangPwd;
    private String s1;
    private String md5;
    private String s2;

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


        edEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c >= 0x4e00 && c <= 0X9fff) { // 根据字节码判断
                            // 如果是中文，则清除输入的字符，否则保留
                            s.delete(i, i + 1);
                        }
                    }
                }
            }
        });


        edPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c >= 0x4e00 && c <= 0X9fff) { // 根据字节码判断
                            // 如果是中文，则清除输入的字符，否则保留
                            s.delete(i, i + 1);
                        }
                    }
                }
            }
        });



    }
    public void login() {
        Log.d(TAG, "gotResult: "+"登录");
        JMessageClient.login(userName, md5, new BasicCallback() {

            @Override
            public void gotResult(int arg0, String arg1) {
                Log.d(TAG, "gotResult: "+arg1);
                if (arg0==0) {
                    Toast.makeText(DengActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public void onDengSuccess(LoginBean loginBean) {
        Log.d(TAG, "onDengSuccess: " + loginBean.getMessage());
        if ("0000".equals(loginBean.getStatus())) {
            LoginBean.ResultBean result = loginBean.getResult();
            userName = result.getUserName();
            jiGuangPwd = result.getJiGuangPwd();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DengActivity.this, HomeActivity.class);
            SharedPreferences.Editor edit = sp.edit();
            edit.putInt("id", loginBean.getResult().getId());
            edit.putString("s", loginBean.getResult().getSessionId());
            edit.commit();
            startActivity(intent);
            try {
                s2 = RsaCoder.decryptByPublicKey(jiGuangPwd);
                Log.d(TAG, "jgpwd: "+jiGuangPwd);
                Log.d(TAG, "jiguang: "+s2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            md5 = MD5(s2);

            Log.d(TAG, "onDengSuccess: "+md5);
            login();
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
                Intent intent = new Intent(DengActivity.this, GeRenXinXiActivity.class);
                startActivity(intent);
                break;
            case R.id.but_denglu:
                email = edEmail.getText().toString();
                pwd = edPwd.getText().toString();

                if (email.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(this, "邮箱密码不可以为空", Toast.LENGTH_SHORT).show();
                } else {

                    try {

                        s = RsaCoder.encryptByPublicKey(pwd);
                        Log.d(TAG, "onViewClicked: "+s);




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

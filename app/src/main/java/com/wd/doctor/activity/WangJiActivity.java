package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.contract.EmailContract;
import com.wd.doctor.presenter.EmailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WangJiActivity extends BaseActivity<EmailPresenter> implements EmailContract.Iview {

    @BindView(R2.id.fanhui_wangji)
    ImageView fanhui_wangji;
    @BindView(R2.id.new_email)
    EditText newEmail;
    @BindView(R2.id.btn_email)
    CheckBox btnEmail;
    @BindView(R2.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R2.id.edit_code)
    EditText editCode;
    @BindView(R2.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R2.id.next)
    Button next;

    @Override
    protected EmailPresenter providePresenter() {
        return new EmailPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wang_ji;
    }


    @Override
    public void onEmailSuccess(SendEmailCodeBean sendEmailCodeBean) {
        //邮箱
        if (sendEmailCodeBean.getStatus().equals("0000")) {
            Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, sendEmailCodeBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onEmailFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui_wangji, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui_wangji:
                finish();
                break;
            case R.id.next:
                String email = newEmail.getText().toString();
                String yzm = editCode.getText().toString();
                if (email.isEmpty() || yzm.isEmpty()) {
                    Toast.makeText(this, "邮箱，验证码不可以为空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(WangJiActivity.this, XiuGaiActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }


    @OnClick(R.id.btn_email)
    public void onViewClicked() {
        String email = newEmail.getText().toString();
        mpresenter.onEmailPresenter(email);
    }
}

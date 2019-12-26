package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiuGaiActivity extends BaseActivity {


    @BindView(R2.id.fanhui_xiugai)
    ImageView fanhui_xiugai;
    @BindView(R2.id.new_email1)
    EditText newEmail1;
    @BindView(R2.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R2.id.edit_code1)
    EditText editCode1;
    @BindView(R2.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R2.id.next2)
    Button next2;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiu_gai;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui_xiugai, R.id.next2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui_xiugai:
                finish();
                break;
            case R.id.next2:
                Intent intent = new Intent(XiuGaiActivity.this, DengActivity.class);
                startActivity(intent);
                break;
        }
    }
}

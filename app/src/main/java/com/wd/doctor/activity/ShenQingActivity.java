package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShenQingActivity extends BaseActivity {


    @BindView(R2.id.fanhui_shenqing)
    SimpleDraweeView fanhui_shenqing;
    @BindView(R2.id.ed_jianjie)
    EditText edJianjie;
    @BindView(R2.id.ed_lingyu)
    EditText edLingyu;
    @BindView(R2.id.but_rz)
    Button butRz;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_shen_qing;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui_shenqing, R.id.but_rz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui_shenqing:
                finish();
                break;
            case R.id.but_rz:
                Intent intent = new Intent(ShenQingActivity.this, WanChengActivity.class);
                startActivity(intent);
                break;
        }
    }
}

package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WanChengActivity extends BaseActivity {

    @BindView(R.id.back_fanhui)
    Button backFanhui;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wan_cheng;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_fanhui)
    public void onViewClicked() {
        Intent intent = new Intent(WanChengActivity.this, DengActivity.class);
        startActivity(intent);
    }
}

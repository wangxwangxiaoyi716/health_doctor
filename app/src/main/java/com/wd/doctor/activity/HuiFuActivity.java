package com.wd.doctor.activity;

import android.os.Bundle;
import android.widget.Switch;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuiFuActivity extends BaseActivity {
    @BindView(R.id.fanhui_sim)
    SimpleDraweeView fanhuiSim;
    @BindView(R.id.item_switch)
    Switch itemSwitch;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_hui_fu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fanhui_sim)
    public void onViewClicked() {
        finish();
    }
}

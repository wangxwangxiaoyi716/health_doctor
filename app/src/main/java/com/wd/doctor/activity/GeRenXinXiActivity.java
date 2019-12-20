package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.wd.doctor.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GeRenXinXiActivity extends BaseActivity {


    @BindView(R.id.but_netgeren)
    Button butNetgeren;
    @BindView(R.id.ed_xm)
    EditText edXm;
    @BindView(R.id.ed_yi)
    EditText edYi;
    @BindView(R.id.ed_mm1)
    EditText edMm1;
    @BindView(R.id.ed_mm2)
    EditText edMm2;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ge_ren_xin_xi;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.but_netgeren)
    public void onViewClicked() {
        Intent intent = new Intent(GeRenXinXiActivity.this, RuZhuActivity.class);
        startActivity(intent);
    }
}

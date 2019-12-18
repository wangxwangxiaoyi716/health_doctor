package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GeRenXinXiActivity extends BaseActivity {


    @BindView(R.id.ed_ruzhuyx)
    EditText edRuzhuyx;
    @BindView(R.id.ed_ruzhuyzm)
    EditText edRuzhuyzm;
    @BindView(R.id.ed_ruzhupwd)
    EditText edRuzhupwd;
    @BindView(R.id.ed_ruzhupwd2)
    EditText edRuzhupwd2;
    @BindView(R.id.but_netgeren)
    Button butNetgeren;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ge_ren_xin_xi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.but_netgeren)
    public void onViewClicked() {
        Intent intent = new Intent(GeRenXinXiActivity.this, ShenQingActivity.class);
        startActivity(intent);
    }
}

package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TiXianActivity extends BaseActivity {

    @BindView(R.id.sim_fanhuitixian_view)
    SimpleDraweeView sim_fanhuitixian_view;
    @BindView(R.id.daozhang)
    TextView daozhang;
    @BindView(R.id.yinhang)
    TextView yinhang;
    @BindView(R.id.jine)
    TextView jine;
    @BindView(R.id.qian)
    TextView qian;
    @BindView(R.id.xuan)
    CheckBox xuan;
    @BindView(R.id.xian)
    TextView xian;
    @BindView(R.id.button_tixian)
    Button buttonTixian;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ti_xian;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhuitixian_view, R.id.button_tixian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhuitixian_view:
                finish();
                break;
            case R.id.button_tixian:
                Intent intent = new Intent(TiXianActivity.this, TiActivity.class);
                startActivity(intent);
                break;
        }
    }
}

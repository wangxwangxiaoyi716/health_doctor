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
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TiXianActivity extends BaseActivity {

    @BindView(R2.id.sim_fanhuitixian_view)
    SimpleDraweeView sim_fanhuitixian_view;
    @BindView(R2.id.daozhang)
    TextView daozhang;
    @BindView(R2.id.yinhang)
    TextView yinhang;
    @BindView(R2.id.jine)
    TextView jine;
    @BindView(R2.id.qian)
    TextView qian;
    @BindView(R2.id.xuan)
    CheckBox xuan;
    @BindView(R2.id.xian)
    TextView xian;
    @BindView(R2.id.button_tixian)
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

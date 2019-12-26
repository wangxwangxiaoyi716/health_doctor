package com.wd.doctor.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TiActivity extends BaseActivity {

    @BindView(R2.id.bu_tixian)
    Button buTixian;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ti;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bu_tixian)
    public void onViewClicked() {
        finish();
    }
}

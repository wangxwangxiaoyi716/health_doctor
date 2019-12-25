package com.wd.doctor.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WenXiaoXiActivity extends BaseActivity {


    @BindView(R.id.sim_fanhuiwenzhen_view)
    SimpleDraweeView sim_fanhuiwenzhen_view;
    @BindView(R.id.bbbb)
    RelativeLayout bbbb;
    @BindView(R.id.recy_xitong)
    RecyclerView recyXitong;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wen_xiao_xi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sim_fanhuiwenzhen_view)
    public void onViewClicked() {
        finish();
    }
}

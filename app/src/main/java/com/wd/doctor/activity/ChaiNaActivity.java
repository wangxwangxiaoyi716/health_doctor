package com.wd.doctor.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChaiNaActivity extends BaseActivity {

    @BindView(R2.id.sim_fanhuicaina_view)
    SimpleDraweeView sim_fanhuicaina_view;
    @BindView(R2.id.relayout_vvv)
    RelativeLayout relayoutVvv;
    @BindView(R2.id.recy_caina)
    RecyclerView recyCaina;


    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_chai_na;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sim_fanhuicaina_view)
    public void onViewClicked() {
        finish();
    }
}

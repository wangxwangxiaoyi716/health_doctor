package com.wd.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaoXiActivity extends BaseActivity {

    @BindView(R.id.sim_fanhui_view)
    SimpleDraweeView simFanhuiView;
    @BindView(R.id.xitongxiaoxi)
    LinearLayout xitongxiaoxi;
    @BindView(R.id.wenzhenxiaoxi)
    LinearLayout wenzhenxiaoxi;
    @BindView(R.id.ruzhangxinxi)
    LinearLayout ruzhangxinxi;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiao_xi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sim_fanhui_view)
    public void onViewClicked() {
        finish();
    }

    @OnClick({R.id.xitongxiaoxi, R.id.wenzhenxiaoxi, R.id.ruzhangxinxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xitongxiaoxi:
                Intent intent = new Intent(XiaoXiActivity.this, XiTongActivity.class);
                startActivity(intent);
                break;
            case R.id.wenzhenxiaoxi:
                Intent intent2 = new Intent(XiaoXiActivity.this, WenXiaoXiActivity.class);
                startActivity(intent2);
                break;
            case R.id.ruzhangxinxi:
                Intent intent3 = new Intent(XiaoXiActivity.this, RuZhangXiaoXiActivity.class);
                startActivity(intent3);
                break;
        }
    }
}

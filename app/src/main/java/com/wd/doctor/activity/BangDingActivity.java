package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BangDingActivity extends BaseActivity {

    @BindView(R.id.sim_fanhui_view)
    SimpleDraweeView simFanhuiView;
    @BindView(R.id.text_shenfenzheng)
    TextView textShenfenzheng;
    @BindView(R.id.text_yinhangka)
    TextView textYinhangka;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_bang_ding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhui_view, R.id.text_shenfenzheng, R.id.text_yinhangka})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhui_view:
                finish();
                break;
            case R.id.text_shenfenzheng:
                Intent intent = new Intent(BangDingActivity.this, ShenFenZhengActivity.class);
                startActivity(intent);
                break;
            case R.id.text_yinhangka:
                Intent intent2 = new Intent(BangDingActivity.this, YinHangKaActivity.class);
                startActivity(intent2);
                break;
        }
    }
}

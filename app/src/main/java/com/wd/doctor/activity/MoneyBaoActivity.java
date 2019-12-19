package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoneyBaoActivity extends BaseActivity {
    @BindView(R.id.sim_fanhui_view)
    SimpleDraweeView simFanhuiView;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.but_tixian)
    Button butTixian;
    @BindView(R.id.recy_moneybao)
    RecyclerView recyMoneybao;
    @BindView(R.id.text_bangding)
    TextView textBangding;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_money_bao;
    }


    @Override
    protected void initData() {
        super.initData();
        textBangding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoneyBaoActivity.this, BangDingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhui_view, R.id.but_tixian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhui_view:
                finish();
                break;
            case R.id.but_tixian:
                Intent intent = new Intent(MoneyBaoActivity.this, TiXianActivity.class);
                startActivity(intent);
                break;
        }
    }
}

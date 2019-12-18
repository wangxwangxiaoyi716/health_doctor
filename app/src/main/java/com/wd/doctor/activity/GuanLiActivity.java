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

public class GuanLiActivity extends BaseActivity {


    @BindView(R.id.sim_fanhui)
    SimpleDraweeView simFanhui;
    @BindView(R.id.img_zpys)
    SimpleDraweeView imgZpys;
    @BindView(R.id.text_zhiliao)
    TextView textZhiliao;
    @BindView(R.id.sim_wenzhen)
    SimpleDraweeView simWenzhen;
    @BindView(R.id.sim_qianbao)
    SimpleDraweeView simQianbao;
    @BindView(R.id.sim_jianyi)
    SimpleDraweeView simJianyi;
    @BindView(R.id.sim_xiaoxi)
    SimpleDraweeView simXiaoxi;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_guan_li;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhui, R.id.text_zhiliao, R.id.sim_wenzhen, R.id.sim_qianbao, R.id.sim_jianyi, R.id.sim_xiaoxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhui:
                finish();
                break;
            case R.id.text_zhiliao:
                Intent intent = new Intent(GuanLiActivity.this, ZhiLiaoActivity.class);
                startActivity(intent);
                break;
            case R.id.sim_wenzhen:
                break;
            case R.id.sim_qianbao:
                Intent intent1 = new Intent(GuanLiActivity.this, MoneyBaoActivity.class);
                startActivity(intent1);
                break;
            case R.id.sim_jianyi:
                Intent intent3 = new Intent(GuanLiActivity.this, ChaiNaActivity.class);
                startActivity(intent3);
                break;
            case R.id.sim_xiaoxi:
                Intent intent2 = new Intent(GuanLiActivity.this, HuiFuActivity.class);
                startActivity(intent2);
                break;
        }
    }
}

package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.LiShiWhenZhenAdapter;
import com.wd.doctor.bean.LiShiWenZhenBean;
import com.wd.doctor.contract.LiShiWenZhenContract;
import com.wd.doctor.presenter.LiShiWenZhenPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiShiJILuActivity extends BaseActivity<LiShiWenZhenPresenter> implements LiShiWenZhenContract.Iview {

    @BindView(R.id.sim_lishifanhui_view)
    SimpleDraweeView simLishifanhuiView;
    @BindView(R.id.text_liwu)
    TextView textLiwu;
    @BindView(R.id.lishi_wenzhenrecy)
    RecyclerView lishiWenzhenrecy;
    private SharedPreferences sp;

    @Override
    protected LiShiWenZhenPresenter providePresenter() {
        return new LiShiWenZhenPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_li_shi_jilu;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        String s = sp.getString("s", null);
        mpresenter.onLiShiWenZhenPresenter(id + "", s, "1", "10");
    }

    @Override
    public void onLiShiWenZhenSuccess(LiShiWenZhenBean liShiWenZhenBean) {
        //历史问诊
        if (liShiWenZhenBean.getStatus().equals("0000")) {
            List<LiShiWenZhenBean.ResultBean> result = liShiWenZhenBean.getResult();
            if (result != null) {
                LiShiWhenZhenAdapter liShiWhenZhenAdapter = new LiShiWhenZhenAdapter(LiShiJILuActivity.this,result);
                lishiWenzhenrecy.setAdapter(liShiWhenZhenAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LiShiJILuActivity.this);
                lishiWenzhenrecy.setLayoutManager(linearLayoutManager);
            }
        } else {
            Toast.makeText(this, liShiWenZhenBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLiShiWenZhenFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_lishifanhui_view, R.id.text_liwu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_lishifanhui_view:
                finish();
                break;
            case R.id.text_liwu:
                //跳转礼物页面
                Intent intent = new Intent(LiShiJILuActivity.this, LiWuActivity.class);
                startActivity(intent);
                break;
        }
    }
}

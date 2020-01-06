package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.adapter.ShouZhiJiLuAdapter;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.ShouZhiJiLuBean;
import com.wd.doctor.contract.DectorMoneyContract;
import com.wd.doctor.presenter.DectorMoneyPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoneyBaoActivity extends BaseActivity<DectorMoneyPresenter> implements DectorMoneyContract.Iview {
    public static final String TAG ="MoneyBaoActivity";
    @BindView(R2.id.sim_fanhuiqianbao_view)
    SimpleDraweeView sim_fanhuiqianbao_view;
    @BindView(R2.id.money)
    TextView money;
    @BindView(R2.id.but_tixian)
    Button butTixian;
    @BindView(R2.id.recy_moneybao)
    RecyclerView recyMoneybao;
    @BindView(R2.id.text_bangding)
    TextView textBangding;
    private SharedPreferences sp;

    @Override
    protected DectorMoneyPresenter providePresenter() {
        return new DectorMoneyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_money_bao;
    }


    @Override
    protected void initData() {
        super.initData();

        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        String s = sp.getString("s", null);
        mpresenter.onDectorMoneyPresenter(id+"",s);

       mpresenter.onShouZhiJiLuPresenter(id+"",s,"1","10");

        //跳转绑定
        textBangding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoneyBaoActivity.this, BangDingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDectorMoneySuccess(DectorMomeyBean dectorMomeyBean) {
        Log.d(TAG, "onDectorMoneySuccess: "+dectorMomeyBean.getMessage());
        if (dectorMomeyBean.getStatus().equals("0000")){
            DectorMomeyBean.ResultBean result = dectorMomeyBean.getResult();
            if (result != null){
                money.setText(result.getBalance()+"");
            }
        }else {
            Toast.makeText(this, dectorMomeyBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onShouZhiJiLuSuccess(ShouZhiJiLuBean shouZhiJiLuBean) {
        //收支记录
        Log.d(TAG, "onShouZhiJiLuSuccess: "+shouZhiJiLuBean.getMessage());
        if (shouZhiJiLuBean.getStatus().equals("0000")){
            List<ShouZhiJiLuBean.ResultBean> result = shouZhiJiLuBean.getResult();
            if (result != null){

                ShouZhiJiLuAdapter shouZhiJiLuAdapter = new ShouZhiJiLuAdapter(MoneyBaoActivity.this,result);
                recyMoneybao.setAdapter(shouZhiJiLuAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoneyBaoActivity.this);
                recyMoneybao.setLayoutManager(linearLayoutManager);
            }
        }else {
            Toast.makeText(this, shouZhiJiLuBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDectorMoneyFliuse(String e) {
        Log.d(TAG, "onDectorMoneyFliuse: "+e.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhuiqianbao_view, R.id.but_tixian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhuiqianbao_view:
                finish();
                break;
            case R.id.but_tixian:
                Intent intent = new Intent(MoneyBaoActivity.this, TiXianActivity.class);
                startActivity(intent);
                break;
        }
    }


}

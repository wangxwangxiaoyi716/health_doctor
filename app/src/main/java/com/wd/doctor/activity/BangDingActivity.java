package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.ChaYinHangCardBean;
import com.wd.doctor.contract.ChaYinHangCardContract;
import com.wd.doctor.presenter.ChaYinHuangCardPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BangDingActivity extends BaseActivity<ChaYinHuangCardPresenter> implements ChaYinHangCardContract.Iview {

    @BindView(R2.id.sim_fanhuibangding_view)
    SimpleDraweeView sim_fanhuibangding_view;
    @BindView(R2.id.text_shenfenzheng)
    TextView textShenfenzheng;
    @BindView(R2.id.text_yinhangka)
    TextView textYinhangka;
    @BindView(R2.id.yinhangcrad_name)
    TextView yinhangcradName;
    @BindView(R2.id.yinhangcrad_type)
    TextView yinhangcradType;
    @BindView(R2.id.yinhangcrad_haoma)
    TextView yinhangcradHaoma;
    private SharedPreferences sp;
    private int id;
    private String s;

    @Override
    protected ChaYinHuangCardPresenter providePresenter() {
        return new ChaYinHuangCardPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_bang_ding;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
        mpresenter.onChaYinHangCardPresenter(id+"",s);
    }

    @Override
    public void onChaYinHangCardSuccess(ChaYinHangCardBean chaYinHangCardBean) {
        if (chaYinHangCardBean.getStatus().equals("0000")){
            ChaYinHangCardBean.ResultBean result = chaYinHangCardBean.getResult();
            if (result != null){
                yinhangcradName.setText(result.getBankName());
                yinhangcradType.setText(result.getBankCardType()+"");
                yinhangcradHaoma.setText(result.getBankCardNumber());
            }
        }else {
            Toast.makeText(this, chaYinHangCardBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onChaYinHangCardFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhuibangding_view, R.id.text_shenfenzheng, R.id.text_yinhangka})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhuibangding_view:
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

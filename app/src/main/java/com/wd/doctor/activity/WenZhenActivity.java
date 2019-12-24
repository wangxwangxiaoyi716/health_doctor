package com.wd.doctor.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.WhenZhenLeiBiaoAdapter;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.contract.WenZhenContract;
import com.wd.doctor.presenter.WenZhenPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WenZhenActivity extends BaseActivity<WenZhenPresenter> implements WenZhenContract.Iview {

    @BindView(R.id.sim_fanhui_view)
    SimpleDraweeView simFanhuiView;
    @BindView(R.id.wenzhen_recy)
    RecyclerView wenzhenRecy;
    private SharedPreferences sp;

    @Override
    protected WenZhenPresenter providePresenter() {
        return new WenZhenPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wen_zhen;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        String s = sp.getString("s", null);
        mpresenter.onWenZhenPresenter(id + "", s);
    }

    @Override
    public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {
        //问诊列表
        if (wenZhenLeiBiaoBean.getStatus().equals("0000")) {
            List<WenZhenLeiBiaoBean.ResultBean> result = wenZhenLeiBiaoBean.getResult();
            if (result != null){
                WhenZhenLeiBiaoAdapter whenZhenLeiBiaoAdapter = new WhenZhenLeiBiaoAdapter(WenZhenActivity.this,result);
                wenzhenRecy.setAdapter(whenZhenLeiBiaoAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WenZhenActivity.this);
                wenzhenRecy.setLayoutManager(linearLayoutManager);

            }
        } else {
            Toast.makeText(this, wenZhenLeiBiaoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onWenZhenFiuse(String e) {

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


}

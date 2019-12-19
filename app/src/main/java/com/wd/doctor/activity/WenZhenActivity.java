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
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.contract.WenZhenContract;
import com.wd.doctor.presenter.WenZhenPresenter;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WenZhenActivity extends BaseActivity<WenZhenPresenter> implements WenZhenContract.Iview {

    @BindView(R.id.sim_fanhui_view)
    SimpleDraweeView simFanhuiView;
    @BindView(R.id.wenzhen_recy)
    RecyclerView wenzhenRecy;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_ke)
    RelativeLayout includeRelate;
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
    public void onWenZhenSuccess(FindInquiryRecordListBean findInquiryRecordListBean) {
        //问诊列表
        if (findInquiryRecordListBean.getStatus().equals("0000")) {

        } else {
            Toast.makeText(this, findInquiryRecordListBean.getMessage(), Toast.LENGTH_SHORT).show();
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

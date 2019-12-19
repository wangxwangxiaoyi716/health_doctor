package com.wd.doctor.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.MoHuChaXunAdapter;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.contract.MoHuChaContract;
import com.wd.doctor.presenter.MoHuChaPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoHuChaActivity extends BaseActivity<MoHuChaPresenter> implements MoHuChaContract.Iview {

    @BindView(R.id.fanhui_text)
    SimpleDraweeView fanhuiText;
    @BindView(R.id.ed_mohucha)
    EditText edMohucha;
    @BindView(R.id.but_bingquanshou)
    Button butBingquanshou;
    @BindView(R.id.recy_modainying)
    RecyclerView recyModainying;
    @BindView(R.id.include_img)
    SimpleDraweeView includeImg;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_mao)
    RelativeLayout includeRelate;

    @Override
    protected MoHuChaPresenter providePresenter() {
        return new MoHuChaPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mo_hu_cha;
    }


    @Override
    public void onMoHuChaSuccess(SearchSickCircleBean searchSickCircleBean) {
        //模糊查询
        if (searchSickCircleBean.getStatus().equals("0000")){
            List<SearchSickCircleBean.ResultBean> result = searchSickCircleBean.getResult();
            if (result != null){
                recyModainying.setVisibility(View.VISIBLE);
                includeRelate.setVisibility(View.GONE);
                MoHuChaXunAdapter moHuChaXunAdapter = new MoHuChaXunAdapter(MoHuChaActivity.this,result);
                recyModainying.setAdapter(moHuChaXunAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoHuChaActivity.this);
                recyModainying.setLayoutManager(linearLayoutManager);
            }else {
                recyModainying.setVisibility(View.GONE);
                includeRelate.setVisibility(View.VISIBLE);
            }
        }else {
            Toast.makeText(this, searchSickCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMoHuFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui_text, R.id.but_bingquanshou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui_text:
                finish();
                break;
            case R.id.but_bingquanshou:
                String mohu = edMohucha.getText().toString();
                mpresenter.onMoHuChaPresenter(mohu);
                break;
        }
    }


}

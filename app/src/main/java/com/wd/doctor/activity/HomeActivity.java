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
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.text_wenzhen)
    TextView textWenzhen;
    @BindView(R.id.text_dayi)
    TextView textDayi;
    @BindView(R.id.sim_doclor)
    SimpleDraweeView simDoclor;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_dzyiyuan)
    TextView textDzyiyuan;
    @BindView(R.id.text_yishi)
    TextView textYishi;
    @BindView(R.id.text_erke)
    TextView textErke;
    @BindView(R.id.text_guanli)
    TextView textGuanli;
    @BindView(R.id.relate_bage01)
    RelativeLayout relateBage01;
    @BindView(R.id.relate_bage02)
    RelativeLayout relateBage02;
    @BindView(R.id.sim_xiaoxi)
    SimpleDraweeView simXiaoxi;
    @BindView(R.id.relayout_gl)
    RelativeLayout relayoutGl;
    private SharedPreferences sp;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        String s = sp.getString("s", null);
        mpresenter.onFindDoctorPresenter(id + "", s);

        relayoutGl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(HomeActivity.this, GuanLiActivity.class);
                startActivity(intent9);
            }
        });

    }

    @Override
    public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

        if (findDoctorByIdBean.getStatus().equals("0000")) {
            FindDoctorByIdBean.ResultBean result = findDoctorByIdBean.getResult();
            if (result != null) {
                textName.setText(result.getName());
                textDzyiyuan.setText(result.getInauguralHospital());
                textYishi.setText(result.getJobTitle());
                textErke.setText(result.getDepartmentName());
            }
        } else {
            Toast.makeText(this, findDoctorByIdBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

    }

    @Override
    public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {

    }

    @Override
    public void onHomeFiluse(String e) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_wenzhen, R.id.text_dayi, R.id.text_guanli, R.id.relate_bage01, R.id.relate_bage02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_wenzhen:
                Intent intent1 = new Intent(HomeActivity.this, WenZhenActivity.class);
                startActivity(intent1);
                break;
            case R.id.text_dayi:
                Intent intent2 = new Intent(HomeActivity.this, DaYiActivity.class);
                startActivity(intent2);
                break;
            case R.id.text_guanli:
                Intent intent3 = new Intent(HomeActivity.this, GuanLiActivity.class);
                startActivity(intent3);
                break;
            case R.id.relate_bage01:
                Intent intent4 = new Intent(HomeActivity.this, WenZhenActivity.class);
                startActivity(intent4);
                break;
            case R.id.relate_bage02:
                Intent intent5 = new Intent(HomeActivity.this, DaYiActivity.class);
                startActivity(intent5);
                break;
        }
    }


    @OnClick(R.id.sim_xiaoxi)
    public void onViewClicked() {
        Intent intent = new Intent(HomeActivity.this, XiaoXiActivity.class);
        startActivity(intent);
    }
}

package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.FindDePartMentAdapter;
import com.wd.doctor.adapter.FindSickCircleListAdapter;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.presenter.HomePresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaYiActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.sim_fanhui)
    SimpleDraweeView simFanhui;
    @BindView(R.id.revy_keshi)
    RecyclerView revyKeshi;
    @BindView(R.id.sim_shoushuo)
    SimpleDraweeView simShoushuo;
    @BindView(R.id.revy_tiaomu)
    RecyclerView revyTiaomu;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_da_yi;
    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.onFindDepartMentPresenter();
        mpresenter.onFindSickCircleListPresenter("1", "1", "5");
    }

    @Override
    public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

    }

    @Override
    public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

        if (findDepartmentBean.getStatus().equals("0000")) {
            //科室列表
            List<FindDepartmentBean.ResultBean> result = findDepartmentBean.getResult();
            if (result != null){
                FindDePartMentAdapter findDePartMentAdapter = new FindDePartMentAdapter(DaYiActivity.this, result);
                revyKeshi.setAdapter(findDePartMentAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DaYiActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                revyKeshi.setLayoutManager(linearLayoutManager);

                findDePartMentAdapter.setSetOnclickListener(new FindDePartMentAdapter.SetOnclickListener() {
                    @Override
                    public void click(int id) {
                        mpresenter.onFindSickCircleListPresenter(id + "", "1", "5");
                    }
                });
            }
        } else {
            Toast.makeText(this, findDepartmentBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {

        if (findSickCircleListBean.getStatus().equals("0000")){
            //病圈列表
            List<FindSickCircleListBean.ResultBean> result = findSickCircleListBean.getResult();
            if (result != null){
                FindSickCircleListAdapter findSickCircleListAdapter = new FindSickCircleListAdapter(DaYiActivity.this, result);
                revyTiaomu.setAdapter(findSickCircleListAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DaYiActivity.this);
                revyTiaomu.setLayoutManager(linearLayoutManager);
            }
        }else {
            Toast.makeText(this, findSickCircleListBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


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

    @OnClick({R.id.sim_fanhui, R.id.sim_shoushuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhui:
                finish();
                break;
            case R.id.sim_shoushuo:
                Intent intent = new Intent(DaYiActivity.this, MoHuChaActivity.class);
                startActivity(intent);
                break;
        }
    }
}

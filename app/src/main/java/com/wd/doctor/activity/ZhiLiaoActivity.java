package com.wd.doctor.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
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

public class ZhiLiaoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.fanhui_zhilaio)
    SimpleDraweeView fanhui_zhilaio;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.textview_mz)
    TextView textviewMz;
    @BindView(R.id.text_yiyuan)
    TextView textYiyuan;
    @BindView(R.id.textview_yiyuan)
    TextView textviewYiyuan;
    @BindView(R.id.text_keshi)
    TextView textKeshi;
    @BindView(R.id.textview_keshi)
    TextView textviewKeshi;
    @BindView(R.id.text_zhicheng)
    TextView textZhicheng;
    @BindView(R.id.textview_zhicheng)
    TextView textviewZhicheng;
    @BindView(R.id.text_gerenjieshao)
    TextView textGerenjieshao;
    @BindView(R.id.text_lingyu)
    TextView textLingyu;
    private SharedPreferences sp;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_zhi_liao;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        String s = sp.getString("s", null);
        mpresenter.onFindDoctorPresenter(id+"",s);
    }
    @Override
    public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

        if (findDoctorByIdBean.getStatus().equals("0000")){
            //资料
            FindDoctorByIdBean.ResultBean result = findDoctorByIdBean.getResult();
            if (result != null){
                textviewMz.setText(result.getName());
                textviewYiyuan.setText(result.getInauguralHospital());
                textviewKeshi.setText(result.getDepartmentName());
                textviewZhicheng.setText(result.getJobTitle());
                textGerenjieshao.setText(result.getPersonalProfile());
                textLingyu.setText(result.getGoodField());
            }

        }else {
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

    @OnClick(R.id.fanhui_zhilaio)
    public void onViewClicked() {
        finish();
    }

}

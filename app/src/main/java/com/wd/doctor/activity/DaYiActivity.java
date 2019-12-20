package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.wd.doctor.R;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.fragment.BingYouQuanFragment;
import com.wd.doctor.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaYiActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.sim_shoushuo)
    SimpleDraweeView simShoushuo;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_page)
    ViewPager viewPage;
    @BindView(R.id.fanhui)
    SimpleDraweeView fanhui;


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

    }

    @Override
    public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

    }

    @Override
    public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

        List<FindDepartmentBean.ResultBean> result = findDepartmentBean.getResult();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add(result.get(i).getDepartmentName());
        }

        viewPage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //创建fragment对象并返回
                Bundle bundle = new Bundle();
                bundle.putInt("id", result.get(position).getId());
                //实例化Fragment
                BingYouQuanFragment homeFragment = new BingYouQuanFragment();
                homeFragment.setArguments(bundle);
                return homeFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

        });
        //关联
        tabLayout.setupWithViewPager(viewPage);
        viewPage.setOffscreenPageLimit(list.size());

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

    @OnClick({R.id.fanhui, R.id.sim_shoushuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.sim_shoushuo:
                Intent intent = new Intent(DaYiActivity.this, MoHuChaActivity.class);
                startActivity(intent);
                break;
        }
    }
}

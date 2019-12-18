package com.wd.doctor.fragment;

import android.os.Bundle;

import com.bw.movie.base.BaseFragment;
import com.wd.doctor.R;
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

/*
 *@auther:王晓义
 *@Date: 2019/12/18
 *@Time:14:52
 *@Description:
 **/
public class BingYouQuanFragment extends BaseFragment<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.xiang_rlv)
    RecyclerView xiangRlv;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.bingyouquan_fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        mPresenter.onFindSickCircleListPresenter(id+"", "1", "5");
    }

    @Override
    public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

    }

    @Override
    public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

    }

    @Override
    public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {
        //详情
        List<FindSickCircleListBean.ResultBean> result = findSickCircleListBean.getResult();
        FindSickCircleListAdapter findSickCircleListAdapter = new FindSickCircleListAdapter(getActivity(),result);
        xiangRlv.setAdapter(findSickCircleListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xiangRlv.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void onHomeFiluse(String e) {

    }
}

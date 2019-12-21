package com.wd.doctor.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.bw.movie.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.doctor.R;
import com.wd.doctor.adapter.FindSickCircleListAdapter;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.presenter.HomePresenter;

import java.util.ArrayList;
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
    int current_page = 1;//当前页，默认第一页
    int pages = 1;//总页数，获取服务端数据
    @BindView(R.id.ward_smart)
    SmartRefreshLayout refreshLayout;
    private ArrayList<FindSickCircleListBean.ResultBean> mList;

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
        mPresenter.onFindSickCircleListPresenter(id + "", "1", "10");

        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                current_page++;
                mPresenter.onFindSickCircleListPresenter(id + "", current_page + "", "10");
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mList.clear();
                current_page = 1;
                mPresenter.onFindSickCircleListPresenter(id + "", current_page + "", "10");
                refreshLayout.finishRefresh();
            }
        });
        refreshLayout.setScrollBoundaryDecider(new ScrollBoundaryDecider() {
            @Override
            public boolean canRefresh(View content) {
                if (xiangRlv == null) return false;
                if (xiangRlv.computeVerticalScrollOffset() == 0)
                    return true;
                return false;
            }

            @Override
            public boolean canLoadMore(View content) {
                if (xiangRlv == null) return false;
                //获取recyclerView的高度
                xiangRlv.getHeight();
                //整个View控件的高度
                int scrollRange = xiangRlv.computeVerticalScrollRange();
                //当前屏幕之前滑过的距离
                int scrollOffset = xiangRlv.computeVerticalScrollOffset();
                //当前屏幕显示的区域高度
                int scrollExtent = xiangRlv.computeVerticalScrollExtent();
                int height = xiangRlv.getHeight();
                if (height > scrollRange) {
                    return false;
                }
                if (scrollRange <= scrollOffset + scrollExtent) {
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {
        //详情
        List<FindSickCircleListBean.ResultBean> result = findSickCircleListBean.getResult();
        mList = new ArrayList<>();
        mList.addAll(result);
        FindSickCircleListAdapter findSickCircleListAdapter = new FindSickCircleListAdapter(getActivity(), result);
        xiangRlv.setAdapter(findSickCircleListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xiangRlv.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

    }

    @Override
    public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

    }

    @Override
    public void onHomeFiluse(String e) {

    }
}

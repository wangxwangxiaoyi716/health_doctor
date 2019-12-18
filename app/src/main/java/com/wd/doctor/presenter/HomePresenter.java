package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.model.HomeModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:9:03
 *@Description:
 **/
public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.Ipresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void onFindDoctorPresenter(String doctorId, String sessionId) {
        homeModel.onFindDoctorModel(doctorId, sessionId, new HomeContract.Imodel.IMtroWork() {
            @Override
            public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {
                getView().onFindDoctorSuccess(findDoctorByIdBean);
            }

            @Override
            public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

            }

            @Override
            public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {

            }

            @Override
            public void onHomeFiluse(String resultes) {
                getView().onHomeFiluse(resultes);
            }
        });
    }

    @Override
    public void onFindDepartMentPresenter() {
        homeModel.onFindDepartMentModel(new HomeContract.Imodel.IMtroWork() {
            @Override
            public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

            }

            @Override
            public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {
                getView().onFindDepartMentSuccess(findDepartmentBean);
            }

            @Override
            public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {

            }

            @Override
            public void onHomeFiluse(String resultes) {
                getView().onHomeFiluse(resultes);
            }
        });
    }

    @Override
    public void onFindSickCircleListPresenter(String departmentId, String page, String count) {
        homeModel.onFindSickCircleListModel(departmentId, page, count, new HomeContract.Imodel.IMtroWork() {
            @Override
            public void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean) {

            }

            @Override
            public void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean) {

            }

            @Override
            public void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean) {
                getView().onFindSickCircleListSuccess(findSickCircleListBean);
            }

            @Override
            public void onHomeFiluse(String resultes) {
                getView().onHomeFiluse(resultes);
            }
        });
    }
}

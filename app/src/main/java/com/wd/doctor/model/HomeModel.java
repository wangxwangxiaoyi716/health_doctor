package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.contract.HomeContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:9:01
 *@Description:
 **/
public class HomeModel implements HomeContract.Imodel {
    @Override
    public void onFindDoctorModel(String doctorId, String sessionId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getdoctor(doctorId, sessionId)
                .compose(CommonSchedulers.<FindDoctorByIdBean> io2main())
                .subscribe(new Observer<FindDoctorByIdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDoctorByIdBean findDoctorByIdBean) {
                        iMtroWork.onFindDoctorSuccess(findDoctorByIdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onHomeFiluse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onFindDepartMentModel(IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getkeshi()
                .compose(CommonSchedulers.<FindDepartmentBean> io2main())
                .subscribe(new Observer<FindDepartmentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindDepartmentBean findDepartmentBean) {
                        iMtroWork.onFindDepartMentSuccess(findDepartmentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onHomeFiluse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onFindSickCircleListModel(String departmentId, String page, String count, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getquanlei(departmentId, page, count)
                .compose(CommonSchedulers.<FindSickCircleListBean> io2main())
                .subscribe(new Observer<FindSickCircleListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindSickCircleListBean findSickCircleListBean) {
                        iMtroWork.onFindSickCircleListSuccess(findSickCircleListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onHomeFiluse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;

import retrofit2.http.Query;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:8:55
 *@Description:
 **/
public interface HomeContract{
    interface Iview extends BaseView{
        void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean);
        void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean);
        void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean);
        void onHomeFiluse(String e);
    }

    interface Imodel{
        void onFindDoctorModel(String doctorId,String sessionId,IMtroWork iMtroWork);
        void onFindDepartMentModel(IMtroWork iMtroWork);
        void onFindSickCircleListModel(String departmentId,String page,String count, IMtroWork iMtroWork);
        interface IMtroWork{
            void onFindDoctorSuccess(FindDoctorByIdBean findDoctorByIdBean);
            void onFindDepartMentSuccess(FindDepartmentBean findDepartmentBean);
            void onFindSickCircleListSuccess(FindSickCircleListBean findSickCircleListBean);
            void onHomeFiluse(String resultes);
        }
    }

    interface Ipresenter{
        void onFindDoctorPresenter(String doctorId,String sessionId);
        void onFindDepartMentPresenter();
        void onFindSickCircleListPresenter(String departmentId,String page,String count);
    }
}

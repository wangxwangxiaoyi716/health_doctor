package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.FaXinXiBean;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;

import retrofit2.http.Header;
import retrofit2.http.Query;

/*
 *@auther:王晓义
 *@Date: 2019/12/16
 *@Time:15:48
 *@Description:
 **/
public interface WenZhenContract {
    interface Iview extends BaseView {
        void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean);
        void onFaXinXiSuccess(FaXinXiBean faXinXiBean);
        void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean);
        void onWenZhenFiuse(String e);
    }


    interface Imodel{
        void onWenZhenModel(String doctorId,String sessionId,IMtroWork iMtroWork);
        void onFaXinXiModel(String doctorId, String sessionId,String inquiryId, String content, String type,String userId, IMtroWork iMtroWork);
        void onChaXinXiModel(String doctorId, String sessionId,String inquiryId,String page,String count, IMtroWork iMtroWork);
        interface IMtroWork{
            void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean);
            void onFaXinXiSuccess(FaXinXiBean faXinXiBean);
            void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean);
            void onWenZhenFiuse(String resultes);
        }
    }

    interface Ipresenter{
        void onWenZhenPresenter(String doctorId, String sessionId);
        void onFaXinXiModel(String doctorId, String sessionId,String inquiryId,String content, String type,String userId);
        void onChaXinXiModel(String doctorId, String sessionId,String inquiryId,String page,String count);
    }
}

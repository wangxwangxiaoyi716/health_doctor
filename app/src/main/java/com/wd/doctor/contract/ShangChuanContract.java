package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.ShangChuanBean;

import okhttp3.MultipartBody;
import retrofit2.http.Header;
import retrofit2.http.Part;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface ShangChuanContract {
    interface Iview extends BaseView {
        void onShangChuanSuccess(ShangChuanBean shangChuanBean);
        void onShangChuanFliuse(String e);
    }


    interface Imodel{
        void onShangChuanModel(String doctorId,String sessionId,MultipartBody.Part imagePic, IMtroWork iMtroWork);
        interface IMtroWork{
            void onShangChuanSuccess(ShangChuanBean shangChuanBean);
            void onShangChuanFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onShangChuanPresenter(String doctorId,String sessionId,MultipartBody.Part imagePic);
    }
}

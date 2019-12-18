package com.wd.doctor.app;

import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.FaPingLunBean;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.bean.XiTongZhaoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *@auther:王晓义
 *@Date: 2019/12/11
 *@Time:15:43
 *@Description:接口
 **/
public interface ApiService {
    //登录
    //http://172.17.8.100/health/doctor/v1/login
    @FormUrlEncoded
    @POST("health/doctor/v1/login")
    Observable<LoginBean> getdeng(@Field("email") String email, @Field("pwd") String pwd);

    //医生信息
    //http://172.17.8.100/health/doctor/verify/v1/findDoctorById
    @GET("health/doctor/verify/v1/findDoctorById")
    Observable<FindDoctorByIdBean> getdoctor(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);


    //科室列表
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDepartment
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<FindDepartmentBean> getkeshi();

    //病友圈列表展示
    @GET("health/user/sickCircle/v1/findSickCircleList")
    Observable<FindSickCircleListBean> getquanlei(@Query("departmentId") String departmentId, @Query("page") String page, @Query("count") String count);


    //查询病友圈详情
    @GET("health/doctor/sickCircle/v1/findSickCircleInfo")
    Observable<SickCircleInfoBean> getbingxiangqing(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId);

    //根据关键词查询病友圈
    //http://172.17.8.100/health/doctor/sickCircle/v1/searchSickCircle
    @GET("health/doctor/sickCircle/v1/searchSickCircle")
    Observable<SearchSickCircleBean> getmohushou(@Query("keyWord") String keyWord);

    //邮箱
    //http://172.17.8.100/health/doctor/v1/sendEmailCode
    @POST("health/doctor/v1/sendEmailCode")
    Observable<SendEmailCodeBean> getemail(@Query("email") String email);


    //查询医生的问诊记录列表
    //http://172.17.8.100/health/doctor/inquiry/verify/v1/findInquiryRecordList
    @GET("health/doctor/inquiry/verify/v1/findInquiryRecordList")
    Observable<FindInquiryRecordListBean> getwenzhenlei(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);


    //申请入驻
    //http://172.17.8.100/health/doctor/v1/applyJoin
    @POST("health/doctor/v1/applyJoin")
    Observable<ApplyJoinBean> getruzhu(@Body Map<String,Object> map);

    //查询系统形象照
    //http://172.17.8.100/health/doctor/v1/findSystemImagePic
    @GET("health/doctor/v1/findSystemImagePic")
    Observable<XiTongZhaoBean> getxtzp();



    //发表评论
    //http://172.17.8.100/health/doctor/sickCircle/verify/v1/publishComment?sickCircleId=22&content=真好
    @POST("health/doctor/sickCircle/verify/v1/publishComment")
    Observable<FaPingLunBean> getfapinglun(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId,@Query("sickCircleId") String sickCircleId,@Query("content") String content);
}

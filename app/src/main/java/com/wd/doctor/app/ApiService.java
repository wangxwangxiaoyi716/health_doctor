package com.wd.doctor.app;

import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.ChaYinHangCardBean;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.FaPingLunBean;
import com.wd.doctor.bean.FaXinXiBean;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindDoctorByIdBean;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.LiShiWenZhenBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.ShangChuanBean;
import com.wd.doctor.bean.ShenFenZhengBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.bean.XiTongZhaoBean;
import com.wd.doctor.bean.YinHangCardBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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
    Observable<WenZhenLeiBiaoBean> getwenzhenlei(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);


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

    //图片上传
    // http://172.17.8.100/health/doctor/verify/v1/uploadImagePic
    @POST("health/doctor/verify/v1/uploadImagePic")
    @Multipart
    Observable<ShangChuanBean> getshangchuan(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Part MultipartBody.Part imagePic);

    //医生钱包
    //http://172.17.8.100/health/doctor/verify/v1/findDoctorWallet
    @GET("health/doctor/verify/v1/findDoctorWallet")
    Observable<DectorMomeyBean> getyishengmoney(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);


    //绑定身份证
    //http://172.17.8.100/health/doctor/verify/v1/bindDoctorIdCard
    @POST("health/doctor/verify/v1/bindDoctorIdCard")
    @Headers({"Content-Type: application/json","Accept: application/json"})
    Observable<ShenFenZhengBean> getshenfenzheng(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Body Map<String,Object> BodyMap);

    //绑定银行卡
    //http://172.17.8.100/health/doctor/verify/v1/bindDoctorBankCard
    @POST("health/doctor/verify/v1/bindDoctorBankCard")
    Observable<YinHangCardBean> getbangyinhangka(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("bankCardNumber") String bankCardNumber, @Query("bankName") String bankName, @Query("bankCardType") String bankCardType);

    //查询医生银行卡信息
    //http://172.17.8.100/health/doctor/verify/v1/findDoctorBankCardById
    @GET("health/doctor/verify/v1/findDoctorBankCardById")
    Observable<ChaYinHangCardBean> getchayinhuang(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId);

    //发送消息（文本消息）
    //http://172.17.8.100/health/doctor/inquiry/verify/v1/pushMessage?inquiryId=3845&content=李泽楷个曲川&type=1&userId=436
    @POST("health/doctor/inquiry/verify/v1/pushMessage")
    Observable<FaXinXiBean> getfaxinxi(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("inquiryId") String inquiryId, @Query("content") String content, @Query("type") String type, @Query("userId") String userId);


    //查询聊天记录
    //http://172.17.8.100/health/doctor/inquiry/verify/v1/findInquiryDetailsList?inquiryId=3845&page=1&count=10
    @GET("health/doctor/inquiry/verify/v1/findInquiryDetailsList")
    Observable<ChaXinXiBean> getchaxinxi(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("inquiryId") String inquiryId, @Query("page") String page, @Query("count") String count);


    //历史问诊记录
    //http://172.17.8.100/health/doctor/inquiry/verify/v1/findHistoryInquiryRecord?page=1&count=10
    @GET("health/doctor/inquiry/verify/v1/findHistoryInquiryRecord?page=1&count=10")
    Observable<LiShiWenZhenBean> getlishijilu(@Header("doctorId") String doctorId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);

}

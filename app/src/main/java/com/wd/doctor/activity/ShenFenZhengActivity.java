package com.wd.doctor.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.bw.movie.Logger;
import com.bw.movie.ToastUtils;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.utils.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.ShenFenZhengBean;
import com.wd.doctor.contract.ShenFenZhengContract;
import com.wd.doctor.presenter.ShenFenZhengPreseneter;
import com.wd.doctor.utils.FileUtil;
import com.wd.doctor.utils.RsaCoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShenFenZhengActivity extends BaseActivity<ShenFenZhengPreseneter> implements ShenFenZhengContract.Iview {


    @BindView(R2.id.sim_fanhuishenfenzheng_view)
    SimpleDraweeView sim_fanhuishenfenzheng_view;
    @BindView(R2.id.sim_xjsfz)
    SimpleDraweeView simXj;
    @BindView(R2.id.text_paizhao)
    TextView textPaizhao;
    @BindView(R2.id.text_paishe)
    TextView textPaishe;
    @BindView(R2.id.button_next)
    Button buttonNext;
    @BindView(R2.id.sim_pzsfz)
    SimpleDraweeView simPzsfz;
    @BindView(R2.id.imgIdCardFront)
    ImageView imgIdCardFront;
    @BindView(R2.id.linearIdCardFront)
    RelativeLayout linearIdCardFront;
    @BindView(R2.id.imgIdCardBack)
    ImageView imgIdCardBack;
    @BindView(R2.id.linearIdCardBack)
    RelativeLayout linearIdCardBack;
    @BindView(R2.id.button_quedingshow)
    Button buttonQuedingshow;
    @BindView(R2.id.sim_shanchu)
    SimpleDraweeView simShanchu;
    @BindView(R2.id.sim_delete)
    SimpleDraweeView simDelete;

    private Dialog dialog;
    private View mInflate;
    public static final String TAG = "IdCardActivity";
    private static final int REQUEST_CODE_CAMERA = 103;
    private SharedPreferences sp;
    private int id;
    private String s;

    private SPUtils idCard;
    private SPUtils idCard2;
    private String name;
    private String sex;
    private String nation;
    private String num;
    private String birthday;
    private String address;
    private String issueAuthority;
    private Map<String, Object> bodyMap;

    @Override
    protected ShenFenZhengPreseneter providePresenter() {
        return new ShenFenZhengPreseneter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_shen_fen_zheng;
    }

    @Override
    protected void initData() {
        super.initData();

        ToastUtils.init(this);
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
        mpresenter.onShenFenZhengPresenter(id + "", s, bodyMap);
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                initLicense();
                String token = accessToken.getAccessToken();
                Logger.e(TAG, token);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.show("初始化认证成功");
                    }
                });
            }

            @Override
            public void onError(OCRError ocrError) {
                Logger.e(TAG, ocrError.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.show("初始化认证失败,请检查 key");
                    }
                });
            }
        }, getApplicationContext(), "7DLt1gb5xVhQSyCxqhSkDHto", "O04NjaRNXOmdgUiabAAjFG7W8omF7P1R");


    }


    @Override
    public void onShenFenZhengSuccess(ShenFenZhengBean shenFenZhengBean) {
        Log.d(TAG, "onShenFenZhengSuccess: " + shenFenZhengBean.getMessage());
        if (shenFenZhengBean.getStatus().equals("0000")) {
            Toast.makeText(this, shenFenZhengBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onShenFenZhengFliuse(String e) {

    }

    private void initLicense() {
        CameraNativeHelper.init(this, OCR.getInstance(ShenFenZhengActivity.this).getLicense(),
                new CameraNativeHelper.CameraNativeInitCallback() {
                    @Override
                    public void onError(int errorCode, Throwable e) {
                        final String msg;
                        switch (errorCode) {
                            case CameraView.NATIVE_SOLOAD_FAIL:
                                msg = "加载so失败，请确保apk中存在ui部分的so";
                                break;
                            case CameraView.NATIVE_AUTH_FAIL:
                                msg = "授权本地质量控制token获取失败";
                                break;
                            case CameraView.NATIVE_INIT_FAIL:
                                msg = "本地质量控制";
                                break;
                            default:
                                msg = String.valueOf(errorCode);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ShenFenZhengActivity.this,
                                        "本地质量控制初始化错误，错误原因： " + msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhuishenfenzheng_view, R.id.sim_xjsfz, R.id.sim_pzsfz, R.id.button_next,R.id.sim_delete,R.id.sim_shanchu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhuishenfenzheng_view:
                finish();
                break;
            case R.id.sim_xjsfz:
                /*show(view);*/
                Intent intent2 = new Intent(ShenFenZhengActivity.this, CameraActivity.class);
                intent2.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent2.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                startActivityForResult(intent2, REQUEST_CODE_CAMERA);
                break;
            case R.id.sim_pzsfz:
                /*show(view);*/
                Intent intent = new Intent(ShenFenZhengActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                break;
            case R.id.button_next:



                break;

            case R.id.sim_delete:
                imgIdCardBack.setVisibility(View.GONE);
                textPaishe.setVisibility(View.VISIBLE);
                simDelete.setVisibility(View.GONE);
                break;
            case R.id.sim_shanchu:
                imgIdCardFront.setVisibility(View.GONE);
                textPaizhao.setVisibility(View.VISIBLE);
                simShanchu.setVisibility(View.GONE);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        imgIdCardFront.setImageBitmap(bitmap);
                        imgIdCardFront.setVisibility(View.VISIBLE);
                        textPaizhao.setVisibility(View.GONE);
                        buttonQuedingshow.setVisibility(View.VISIBLE);
                        simShanchu.setVisibility(View.VISIBLE);
                        /*buttonQuedingShow.setVisibility(View.VISIBLE);*/
                        /*linearIdCardFront.setVisibility(View.GONE);*/
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        imgIdCardBack.setImageBitmap(bitmap);
                        imgIdCardBack.setVisibility(View.VISIBLE);
                        textPaishe.setVisibility(View.GONE);
                        buttonQuedingshow.setVisibility(View.VISIBLE);
                        simDelete.setVisibility(View.VISIBLE);
                        /*buttonQuedingShow.setVisibility(View.VISIBLE);*/
                        /*linearIdCardBack.setVisibility(View.GONE);*/
                    }
                }
            }
        }
    }

    @OnClick(R.id.button_quedingshow)
    public void onViewClicked() {
        try {
            name = RsaCoder.encryptByPublicKey(name);
            sex = RsaCoder.encryptByPublicKey(sex);
            nation = RsaCoder.encryptByPublicKey(nation);
            birthday = RsaCoder.encryptByPublicKey(birthday);
            address = RsaCoder.encryptByPublicKey(address);
            num = RsaCoder.encryptByPublicKey(num);
            issueAuthority = RsaCoder.encryptByPublicKey(issueAuthority);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("doctorId", id + "");
            jsonObject.put("name", name);
            jsonObject.put("sex", sex);
            jsonObject.put("nation", nation);
            jsonObject.put("birthday", birthday);
            jsonObject.put("address", address);
            jsonObject.put("num", num);
            jsonObject.put("issueAuthority", issueAuthority);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray put = jsonArray.put(jsonObject);
        bodyMap = new HashMap<>();
        bodyMap.put("BodyMap", put);

        finish();
    }

    /**
     * 解析身份证图片
     *
     * @param filePath 图片路径
     * @a0GPi4bzLzuT9dDpU5Zp1Ce7InFDAjUw param idCardSide 身份证正反面
     */
    private void recIDCard(final String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(40);
        OCR.getInstance(ShenFenZhengActivity.this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {


            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {

                    name = "";
                    sex = "";
                    nation = "";
                    num = "";
                    birthday = "";
                    address = "";
                    issueAuthority = "";
                    if (result.getName() != null) {
                        name = result.getName().toString();
                    }
                    if (result.getGender() != null) {
                        sex = result.getGender().toString();
                    }
                    if (result.getEthnic() != null) {
                        nation = result.getEthnic().toString();
                    }
                    if (result.getIdNumber() != null) {
                        num = result.getIdNumber().toString();
                    }
                    if (result.getBirthday() != null) {
                        birthday = result.getBirthday().toString();
                    }
                    if (result.getAddress() != null) {
                        address = result.getAddress().toString();
                    }
                    if (result.getIssueAuthority() != null) {
                        issueAuthority = result.getIssueAuthority().toString();
                    }
                    if (idCardSide.equals("front")) {
                        ToastUtils.show("姓名: " + name + "\n" +
                                "性别: " + sex + "\n" +
                                "民族: " + nation + "\n" +
                                "身份证号码: " + num + "\n" +
                                "生日" + birthday + "\n" +
                                "住址: " + address + "\n");

                        /*idCard = new SPUtils(IdCardActivity.this, "IdCard");
                        idCard.SharedPreferenceput("frontyes",true);
                        idCard.SharedPreferenceput("",false);
                        idCard.SharedPreferenceput("name", name);
                        idCard.SharedPreferenceput("sex", sex);
                        idCard.SharedPreferenceput("birthday", birthday);
                        idCard.SharedPreferenceput("address", address);
                        idCard.SharedPreferenceput("num", num);*/
                    } else if (idCardSide.equals("back")) {
                        ToastUtils.show("签发机关: " + issueAuthority + "\n");
                        /*idCard2 = new SPUtils(IdCardActivity.this, "IdCard2");
                        idCard2.SharedPreferenceput("backyes",true);*/
                    }
                }
            }

            @Override
            public void onError(OCRError error) {
                Toast.makeText(ShenFenZhengActivity.this, "识别出错,请查看log错误代码", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "onError: " + error.getMessage());
            }
        });
    }



}

package com.wd.doctor.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.BankCardParams;
import com.baidu.ocr.sdk.model.BankCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.bw.movie.Logger;
import com.bw.movie.ToastUtils;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.YinHangCardBean;
import com.wd.doctor.contract.BangYinHangCradContract;
import com.wd.doctor.presenter.BangYinHangCardPresenter;
import com.wd.doctor.utils.FileUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YinHangKaActivity extends BaseActivity<BangYinHangCardPresenter> implements BangYinHangCradContract.Iview {
    @BindView(R2.id.sim_fanhui_view_bangdingka)
    SimpleDraweeView sim_fanhui_view_bangdingka;
    @BindView(R2.id.sim_pz)
    SimpleDraweeView simPz;

    @BindView(R2.id.bu_next)
    Button buNext;
    @BindView(R2.id.sim_yinhuangshanchu)
    SimpleDraweeView simYinhuangshanchu;
    @BindView(R2.id.yinhang_image)
    ImageView yinhangImage;
    @BindView(R2.id.button_yinhuangquedingshow)
    Button buttonYinhuangquedingshow;
    @BindView(R2.id.bank_card)
    EditText bankCard;
    @BindView(R2.id.text_paishezp)
    TextView textPaishezp;
    private Dialog dialog;
    private View mInflate;
    private int id;
    private String s;
    private SharedPreferences sp;

    public static final String TAG = "YinHangKaActivity";
    private static final int REQUEST_CODE_CAMERA = 103;
    private BankCardResult.BankCardType bankCardType;
    private String bankCardNumber;
    private String bankName;

    @Override
    protected BangYinHangCardPresenter providePresenter() {
        return new BangYinHangCardPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_yin_hang_ka;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
       /* mpresenter.onBangYinHangCradPresenter(id+"",s,bankCardNumber,bankName,bankCardType+"");*/
        initAccessTokenWithAkSk();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_BANK_CARD.equals(contentType)) {
                        recCreditCard(filePath);
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        yinhangImage.setImageBitmap(bitmap);
                        yinhangImage.setVisibility(View.VISIBLE);
                        textPaishezp.setVisibility(View.GONE);
                        buttonYinhuangquedingshow.setVisibility(View.VISIBLE);
                        simYinhuangshanchu.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    private void initLicense() {
        CameraNativeHelper.init(this, OCR.getInstance(YinHangKaActivity.this).getLicense(),
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
                                //                                Toast.makeText(AddBankActivity.this,
                                //                                        "本地质量控制初始化错误，错误原因： " + msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }

    //初始化
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                initLicense();
                String token = accessToken.getAccessToken();
                Logger.e(TAG, token);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(YinHangKaActivity.this, "初始化认证成功", Toast.LENGTH_SHORT).show();
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

    /**
     * 解析银行卡
     *
     * @param filePath 图片路径
     */
    private void recCreditCard(String filePath) {
        // 银行卡识别参数设置
        BankCardParams param = new BankCardParams();
        param.setImageFile(new File(filePath));

        // 调用银行卡识别服务
        OCR.getInstance(YinHangKaActivity.this).recognizeBankCard(param, new OnResultListener<BankCardResult>() {
            @Override
            public void onResult(BankCardResult result) {
                if (result != null) {
                    String type;
                    if (result.getBankCardType() == BankCardResult.BankCardType.Credit) {
                        type = "信用卡";
                    } else if (result.getBankCardType() == BankCardResult.BankCardType.Debit) {
                        type = "借记卡";
                    } else {
                        type = "不能识别";
                    }
                    bankCardType = result.getBankCardType();
                    bankCard.addTextChangedListener(watcher);
                    bankCard.setText(result.getBankCardNumber());
                    bankCardNumber = result.getBankCardNumber();

                    bankName = result.getBankName();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("", true);
                    editor.putString("cardnum", bankCardNumber);
                    editor.putString("bankname", bankName);
                    editor.putString("type", type);
                    editor.clear().commit();
                }
            }

            @Override
            public void onError(OCRError ocrError) {

            }

        });
    }

    // 对输入的银行卡号进行分割，每四个数字隔开
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString().trim().replace(" ", "");
            String result = "";
            if (str.length() >= 4) {
                bankCard.removeTextChangedListener(watcher);
                for (int i = 0; i < str.length(); i++) {
                    result += str.charAt(i);
                    if ((i + 1) % 4 == 0) {
                        result += " ";
                    }
                }
                if (result.endsWith(" ")) {
                    result = result.substring(0, result.length() - 1);
                }
                bankCard.setText(result);
                bankCard.addTextChangedListener(watcher);
                bankCard.setSelection(bankCard.getText().toString().length());//焦点到输入框最后位置
            }
        }
    };

    private void initViews() {


        bankCard.addTextChangedListener(new TextWatcher() {

            private String bankName;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("tag", "输入的数字：" + s);
                String bankNumber = bankCard.getText().toString().trim();

                //根据银行卡号前6位查询银行信息
                if (bankNumber.length() >= 7) {
                    //移除空格
                    String noSpaceNumber = removeAllSpace(bankNumber);
                    //截取前6位
                    String divideStr = noSpaceNumber.substring(0, 6);
                    //通过银行卡号前6位查询开户行信息

                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("bankNumber", bankNumber);
                editor.putString("handname", bankName);
                editor.putBoolean("", true);
                editor.clear().commit();
            }
        });
    }

    /**
     * 移除空格
     *
     * @param str
     * @return
     */
    public String removeAllSpace(String str) {
        String tmpStr = str.replace(" ", "");
        return tmpStr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_fanhui_view_bangdingka, R.id.sim_pz, R.id.bu_next, R.id.sim_yinhuangshanchu, R.id.button_yinhuangquedingshow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_fanhui_view_bangdingka:
                finish();
                break;
            case R.id.sim_pz:
                Intent intent = new Intent(YinHangKaActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_BANK_CARD);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                break;
            case R.id.bu_next:
                break;
            case R.id.sim_yinhuangshanchu:
                yinhangImage.setVisibility(View.GONE);
                textPaishezp.setVisibility(View.VISIBLE);
                simYinhuangshanchu.setVisibility(View.GONE);
                break;
            case R.id.button_yinhuangquedingshow:

                finish();
                break;
        }
    }


    @Override
    public void onBangYinHangCradSuccess(YinHangCardBean yinHangCardBean) {
        if (yinHangCardBean.getStatus().equals("0000")){
            Toast.makeText(this, yinHangCardBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBangYinHangCradFliuse(String e) {

    }
}

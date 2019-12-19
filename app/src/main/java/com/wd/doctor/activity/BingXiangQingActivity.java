package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.FaPingLunBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.contract.BingXiangQingContract;
import com.wd.doctor.presenter.BingXiangQingPresenter;
import com.wd.doctor.view.HideIMEUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BingXiangQingActivity extends BaseActivity<BingXiangQingPresenter> implements BingXiangQingContract.Iview {

    @BindView(R.id.sim_fanhui)
    SimpleDraweeView simFanhui;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_xm)
    TextView textXm;
    @BindView(R.id.text_bingzhneg)
    TextView textBingzhneg;
    @BindView(R.id.text_neike)
    TextView textNeike;
    @BindView(R.id.text_xiangqing)
    TextView textXiangqing;
    @BindView(R.id.text_tiantan)
    TextView textTiantan;
    @BindView(R.id.text_riqi)
    TextView textRiqi;
    @BindView(R.id.text_jingli)
    TextView textJingli;
    @BindView(R.id.but_jieda)
    Button butJieda;
    @BindView(R.id.text_pinglun)
    TextView textPinglun;
    @BindView(R.id.et_find_sick_info)
    EditText etFindSickInfo;
    @BindView(R.id.tv_expression)
    TextView tvExpression;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.linner_ping)
    LinearLayout linnerPing;
    @BindView(R.id.shuru)
    LinearLayout shuru;
    @BindView(R.id.sim_xiangqingzp)
    SimpleDraweeView simXiangqingzp;
    @BindView(R.id.recyxq_include)
    RelativeLayout recyxqInclude;
    @BindView(R.id.textHbi)
    TextView textHbi;
    private SharedPreferences sp;
    private int id;
    private String s;
    private int sickCircleId;
    private int whetherContent;

    @Override
    protected BingXiangQingPresenter providePresenter() {
        return new BingXiangQingPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_bing_xiang_qing;
    }


    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
        Intent intent = getIntent();
        sickCircleId = intent.getIntExtra("sickCircleId", 0);
        mpresenter.onBingXiangQingPresenter(id + "", s, sickCircleId + "");


        butJieda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuru.setVisibility(View.VISIBLE);

            }
        });

        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fb = etFindSickInfo.getText().toString();
                mpresenter.onFaPingLunPresenter(id + "", s, sickCircleId + "", fb);
                shuru.setVisibility(View.GONE);
            }
        });


        /*shuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (whetherContent == 1){
                    recyxqInclude.setVisibility(View.VISIBLE);
                    textHbi.setVisibility(View.GONE);
                    butJieda.setVisibility(View.GONE);
                }else if (whetherContent == 2){
                    recyxqInclude.setVisibility(View.GONE);
                    textHbi.setVisibility(View.VISIBLE);
                    butJieda.setVisibility(View.VISIBLE);
                }
                etFindSickInfo.setVisibility(View.GONE);
                HideIMEUtil.wrap(BingXiangQingActivity.this);
            }
        });*/

    }


    @Override
    public void onBingXiangQing(SickCircleInfoBean sickCircleInfoBean) {

        if (sickCircleInfoBean.getStatus().equals("0000")) {
            //病友圈详情
            SickCircleInfoBean.ResultBean result = sickCircleInfoBean.getResult();

            if (result != null) {
                /*whetherContent = result.getWhetherContent();
                if (whetherContent == 1){
                    recyxqInclude.setVisibility(View.VISIBLE);
                    textHbi.setVisibility(View.GONE);
                    butJieda.setVisibility(View.GONE);
                }else if (whetherContent == 2){
                    recyxqInclude.setVisibility(View.GONE);
                    textHbi.setVisibility(View.VISIBLE);
                    butJieda.setVisibility(View.VISIBLE);
                }
                recyxqInclude.setVisibility(View.GONE);
                HideIMEUtil.wrap(BingXiangQingActivity.this);*/
                textTitle.setText(result.getTitle());
                textXm.setText(result.getAuthorName());
                textBingzhneg.setText(result.getDisease());
                textNeike.setText(result.getDepartmentName());
                textXiangqing.setText(result.getTreatmentProcess());
                textTiantan.setText(result.getDetail());
                Date date = new Date(result.getTreatmentEndTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                textRiqi.setText(simpleDateFormat.format(date));
                textJingli.setText(result.getTreatmentHospital());
                textPinglun.setText(result.getContent());
                simXiangqingzp.setImageURI(result.getPicture());
                textHbi.setText(result.getAmount()+"H币");
            }
        } else {
            Toast.makeText(this, sickCircleInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onFaPingLunSuccess(FaPingLunBean faPingLunBean) {
        //评论
        if (faPingLunBean.getStatus().equals("0000")) {
            Toast.makeText(this, "发表成功", Toast.LENGTH_SHORT).show();
            mpresenter.onBingXiangQingPresenter(id + "", s, sickCircleId + "");
        } else {
            Toast.makeText(this, faPingLunBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onXiangQing(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sim_fanhui)
    public void onViewClicked() {
        finish();
    }


}

package com.wd.doctor.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.EventBusBean;
import com.wd.doctor.bean.HuanZheXiangQingBean;
import com.wd.doctor.contract.HuanZheXiangQingContract;
import com.wd.doctor.presenter.HuanZheXiangQingPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuanZheXinXIActivity extends BaseActivity<HuanZheXiangQingPresenter> implements HuanZheXiangQingContract.Iview {


    @BindView(R.id.sim_huanzhe_bg)
    SimpleDraweeView simHuanzheBg;
    @BindView(R.id.huanzhe_sim_fanhui)
    SimpleDraweeView huanzheSimFanhui;
    @BindView(R.id.sim_huanzhe_sex_nv)
    SimpleDraweeView simHuanzheSexNv;
    @BindView(R.id.sim_huanzhe_sex_nan)
    SimpleDraweeView simHuanzheSexNan;
    @BindView(R.id.text_huanzhe_name)
    TextView textHuanzheName;
    @BindView(R.id.relay_huanzhe_item)
    LinearLayout relayHuanzheItem;
    @BindView(R.id.text_bingzhneg_huanzhe)
    TextView textBingzhnegHuanzhe;
    @BindView(R.id.text_bingshi_huanzhe)
    TextView textBingshiHuanzhe;
    @BindView(R.id.text_bingshijiwang_huanzhe)
    TextView textBingshijiwangHuanzhe;
    @BindView(R.id.text_tiantan_huanzhe)
    TextView textTiantanHuanzhe;
    @BindView(R.id.text_jingli_huanzhe)
    TextView textJingliHuanzhe;
    @BindView(R.id.sim_huanzhe_zp)
    SimpleDraweeView simHuanzheZp;
    @BindView(R.id.sim_yonghu_tx)
    SimpleDraweeView simYonghuTx;
    @BindView(R.id.text_shengao)
    TextView textShengao;
    @BindView(R.id.text_tizhong)
    TextView textTizhong;
    @BindView(R.id.text_nianling)
    TextView textNianling;
    @BindView(R.id.text_riqikaishi_huanzhe)
    TextView textRiqikaishiHuanzhe;
    @BindView(R.id.text_riqijieshu_huanzhe)
    TextView textRiqijieshuHuanzhe;
    private SharedPreferences sp;
    private int userid;

    @Override
    protected HuanZheXiangQingPresenter providePresenter() {
        return new HuanZheXiangQingPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_huan_zhe_xin_xi;
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(HuanZheXinXIActivity.this);
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        String s = sp.getString("s", null);

        mpresenter.onHuanZheXiangQingPresenter(id + "", s, userid + "");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMeassageheight(EventBusBean eventBusBean) {
        userid = eventBusBean.getUserid();
    }

    @Override
    public void onHuanZheXiangQingSuccess(HuanZheXiangQingBean huanZheXiangQingBean) {
        if (huanZheXiangQingBean.getStatus().equals("0000")) {
            HuanZheXiangQingBean.ResultBean result = huanZheXiangQingBean.getResult();
            if (result != null) {
                simYonghuTx.setImageURI(result.getUserHeadPic());
                textHuanzheName.setText(result.getNickName());
                textShengao.setText(result.getHeight()+"cm");
                textTizhong.setText(result.getWeight()+"kg");
                textNianling.setText(result.getAge()+"岁");
                textBingzhnegHuanzhe.setText(result.getDiseaseMain());
                textBingshiHuanzhe.setText(result.getDiseaseNow());
                textBingshijiwangHuanzhe.setText(result.getDiseaseBefore());
                textTiantanHuanzhe.setText(result.getTreatmentHospitalRecent());
                textJingliHuanzhe.setText(result.getTreatmentProcess());
                Date date = new Date(result.getTreatmentStartTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                textRiqikaishiHuanzhe.setText(simpleDateFormat.format(date));
                Date date2 = new Date(result.getTreatmentEndTime());
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                textRiqijieshuHuanzhe.setText(simpleDateFormat2.format(date2));
                simHuanzheZp.setImageURI(result.getPicture());
            }
        } else {
            Toast.makeText(this, huanZheXiangQingBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHuanZheXiangQingFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.huanzhe_sim_fanhui)
    public void onViewClicked() {
        finish();
    }


}

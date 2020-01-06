package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.LiaoTianAdapter;
import com.wd.doctor.adapter.WenZhenJiLuAdapter;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.EventBusBean;
import com.wd.doctor.bean.FaXinXiBean;
import com.wd.doctor.bean.JieShuWhenZhenBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.contract.WenZhenContract;
import com.wd.doctor.presenter.WenZhenPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WenZhenJiLuActivity extends BaseActivity<WenZhenPresenter> implements WenZhenContract.Iview {
public static final String TAG = "WenZhenJiLuActivity";
    @BindView(R.id.sim_fanhuiwenzhenjilu_view)
    SimpleDraweeView simFanhuiwenzhenjiluView;
    @BindView(R.id.text_wenzhenjilu_name)
    TextView textWenzhenjiluName;
    @BindView(R.id.wenzhenjilu_recy_view)
    RecyclerView wenzhenjiluRecyView;
    private SharedPreferences sp;
    private String s;
    private int id;
    private int inquiryId;
    private String nickName;

    @Override
    protected WenZhenPresenter providePresenter() {
        return new WenZhenPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wen_zhen_ji_lu;
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(WenZhenJiLuActivity.this);

        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
        mpresenter.onChaXinXiModel(id + "", s, inquiryId + "", "1", "20");
        Intent intent = getIntent();
        nickName = intent.getStringExtra("nickName");
        Log.d(TAG, "initData: "+ nickName);
        textWenzhenjiluName.setText(nickName);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMeassageheight(EventBusBean eventBusBean) {
        inquiryId = eventBusBean.getInquiryId();

    }

    @Override
    public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {

    }

    @Override
    public void onFaXinXiSuccess(FaXinXiBean faXinXiBean) {

    }

    @Override
    public void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean) {
        //查聊天记录
        //查信息
        if (chaXinXiBean.getStatus().equals("0000")) {
            List<ChaXinXiBean.ResultBean> result = chaXinXiBean.getResult();
            if (result != null) {
                //适配器
                WenZhenJiLuAdapter wenZhenJiLuAdapter = new WenZhenJiLuAdapter(WenZhenJiLuActivity.this, result);
                wenzhenjiluRecyView.setAdapter(wenZhenJiLuAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WenZhenJiLuActivity.this);
                linearLayoutManager.setStackFromEnd(true);
                wenzhenjiluRecyView.setLayoutManager(linearLayoutManager);
                linearLayoutManager.setReverseLayout(true);//布局反向
                linearLayoutManager.setStackFromEnd(true);//数据反向
            }
        } else {
            Toast.makeText(this, chaXinXiBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onJieShuWenZhenSuccess(JieShuWhenZhenBean jieShuWhenZhenBean) {

    }

    @Override
    public void onWenZhenFiuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sim_fanhuiwenzhenjilu_view)
    public void onViewClicked() {
        finish();
    }


}

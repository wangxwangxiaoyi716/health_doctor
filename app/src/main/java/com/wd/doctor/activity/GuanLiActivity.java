package com.wd.doctor.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.utils.SPUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuanLiActivity extends BaseActivity {


    @BindView(R.id.img_zpys)
    ImageView imgZpys;
    @BindView(R.id.text_zhiliao)
    TextView textZhiliao;
    @BindView(R.id.sim_wenzhen)
    SimpleDraweeView simWenzhen;
    @BindView(R.id.sim_qianbao)
    SimpleDraweeView simQianbao;
    @BindView(R.id.sim_jianyi)
    SimpleDraweeView simJianyi;
    @BindView(R.id.sim_xiaoxi)
    SimpleDraweeView simXiaoxi;
    @BindView(R.id.hui)
    SimpleDraweeView hui;
    private Dialog dialog;
    private View mInflate;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_guan_li;
    }


    @Override
    protected void initData() {
        super.initData();
        imgZpys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(view);
            }
        });


        SPUtils zp = new SPUtils(GuanLiActivity.this, "zp");
        String path = zp.getString("path");
        if (path != null){
            Glide.with(this).load(path)
                    .into(imgZpys);
        }

    }


    public void show(View view) {
        dialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(this).inflate(R.layout.genghuan, null);
        //初始化控件
        //更换形象照
        Button mPic = mInflate.findViewById(R.id.set_but_pic);
        //取消
        Button mDiesmiss = mInflate.findViewById(R.id.set_but_dismiss);
        /*点击*/
        //调起相机
        mPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //更换形象照
        mPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuanLiActivity.this, ImagePhotoActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        //取消
        mDiesmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //将布局设置给Dialog
        dialog.setContentView(mInflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.hui, R.id.text_zhiliao, R.id.sim_wenzhen, R.id.sim_qianbao, R.id.sim_jianyi, R.id.sim_xiaoxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hui:
                finish();
                break;
            case R.id.text_zhiliao:
                Intent intent = new Intent(GuanLiActivity.this, ZhiLiaoActivity.class);
                startActivity(intent);
                break;
            case R.id.sim_wenzhen:
                break;
            case R.id.sim_qianbao:
                Intent intent1 = new Intent(GuanLiActivity.this, MoneyBaoActivity.class);
                startActivity(intent1);
                break;
            case R.id.sim_jianyi:
                Intent intent3 = new Intent(GuanLiActivity.this, ChaiNaActivity.class);
                startActivity(intent3);
                break;
            case R.id.sim_xiaoxi:
                Intent intent2 = new Intent(GuanLiActivity.this, HuiFuActivity.class);
                startActivity(intent2);
                break;
        }
    }
}

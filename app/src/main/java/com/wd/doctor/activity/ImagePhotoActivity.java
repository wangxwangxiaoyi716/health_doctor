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
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.HuanImageActivity;
import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImagePhotoActivity extends BaseActivity {

    @BindView(R.id.sim_pz)
    SimpleDraweeView simPz;
    @BindView(R.id.xxz)
    TextView xxz;
    @BindView(R.id.buton_wcsz)
    Button butonWcsz;
    private Dialog dialog;
    private View mInflate;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_image_photo;
    }

    @Override
    protected void initData() {
        super.initData();
        simPz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(view);
            }
        });
    }


    public void show(View view) {
        dialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(this).inflate(R.layout.set_ceshi, null);
        //初始化控件
        //相册
        Button mAlbum = mInflate.findViewById(R.id.set_but_album);
        //拍照
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
        //相册
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImagePhotoActivity.this, HuanImageActivity.class);
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




    /*public void show(View view) {
        mDialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(this).inflate(R.layout.set_ceshi, null);
        //初始化控件
        //拍照
        mPic = mInflate.findViewById(R.id.set_but_pic);
        //取消
        mDiesmiss = mInflate.findViewById(R.id.set_but_dismiss);
        //相册
        mAlbum = mInflate.findViewById(R.id.set_but_album);
        *//*点击*//*
        //调起相机
        mPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //相册
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.getInstence().intentStart(SetImageActivity.this, ImagePhotoActivity.class);
                finish();
            }
        });
        //取消
        mDiesmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        //将布局设置给Dialog
        mDialog.setContentView(mInflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = mDialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        mDialog.show();//显示对话框
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buton_wcsz)
    public void onViewClicked() {
    }
}

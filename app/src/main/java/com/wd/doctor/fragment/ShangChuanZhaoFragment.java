package com.wd.doctor.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.utils.SPUtils;
import com.wd.doctor.R;
import com.wd.doctor.bean.ShangChuanBean;
import com.wd.doctor.contract.ShangChuanContract;
import com.wd.doctor.presenter.ShangChuanPresenter;
import com.wd.doctor.view.ImageUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/*
 *@auther:王晓义
 *@Date: 2019/12/20
 *@Time:18:55
 *@Description:
 **/
public class ShangChuanZhaoFragment extends BaseFragment<ShangChuanPresenter> implements ShangChuanContract.Iview {
    public static final String TAG = "ImagePhotoActivity";
    @BindView(R.id.sim_pzimag)
    ImageView simPz;
    @BindView(R.id.xxz)
    TextView xxz;
    @BindView(R.id.buton_wcsz)
    Button butonWcsz;
    private Dialog dialog;
    private View mInflate;
    private MultipartBody.Part picture;
    private SharedPreferences sp;
    private SharedPreferences zp;

    @Override
    protected ShangChuanPresenter providePresenter() {
        return new ShangChuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.shangchuanzhao_fragment;
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

        sp = getActivity().getSharedPreferences("sp", Context.MODE_PRIVATE);
        int id = this.sp.getInt("id", 0);
        String s = this.sp.getString("s", null);
        mPresenter.onShangChuanPresenter(id + "", s, picture);


    }

    @Override
    public void onShangChuanSuccess(ShangChuanBean shangChuanBean) {
        Log.d(TAG, "onShangChuanSuccess: " + shangChuanBean.getMessage());
        if (shangChuanBean.getStatus().equals("0000")) {
            Toast.makeText(getActivity(), "上传成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), shangChuanBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onShangChuanFliuse(String e) {

    }


    public void show(View view) {
        dialog = new Dialog(getActivity(), R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(getActivity()).inflate(R.layout.set_ceshi, null);
        //初始化控件
        //相册
        Button mAlbum = mInflate.findViewById(R.id.set_but_album);
        //拍照
        Button mPic = mInflate.findViewById(R.id.set_but_pic);
        //取消
        Button mDiesmiss = mInflate.findViewById(R.id.set_but_dismiss);
        Button xc = mInflate.findViewById(R.id.but_xc);
        //点击
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
                /*Intent intent = new Intent(getActivity().this, HuanImageActivity.class);
                startActivity(intent);*/
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

//        //相册
        xc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image*/*");
                intent.setType("image/*");
                startActivityForResult(intent, 1);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是不是选中图片了
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {

                    //用一个工具类获取图片的绝对路径,我会粘到下方
                    String path = ImageUtil.getPath(getActivity(), uri);
                    SPUtils zp = new SPUtils(getActivity(), "zp");
                    zp.putString("path", path);
                    Glide.with(getActivity()).load(path)
                            .into(simPz);
                    if (path != null) {
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        picture = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                    }
                }
            } else {
                Toast.makeText(getActivity(), "取消相册", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.buton_wcsz)
    public void onViewClicked() {
        getActivity().finish();
    }
}


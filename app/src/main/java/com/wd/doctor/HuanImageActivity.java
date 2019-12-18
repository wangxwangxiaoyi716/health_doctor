package com.wd.doctor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.wd.doctor.adapter.HuanImageAdapter;
import com.wd.doctor.bean.XiTongZhaoBean;
import com.wd.doctor.contract.HuanImgContract;
import com.wd.doctor.presenter.HuanImagePresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuanImageActivity extends BaseActivity<HuanImagePresenter> implements HuanImgContract.Iview {

    @BindView(R.id.recy_zp)
    RecyclerView recyZp;
    @BindView(R.id.buton_wc)
    Button butonWc;

    @Override
    protected HuanImagePresenter providePresenter() {
        return new HuanImagePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_huan_image;
    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.onHuanImagePresenter();
    }

    @Override
    public void onHuanImageSuccess(XiTongZhaoBean xiTongZhaoBean) {
        //系统照片
        if (xiTongZhaoBean.getStatus().equals("0000")){
            List<XiTongZhaoBean.ResultBean> result = xiTongZhaoBean.getResult();
            if (result != null){
                HuanImageAdapter huanImageAdapter = new HuanImageAdapter(HuanImageActivity.this,result);
                recyZp.setAdapter(huanImageAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HuanImageActivity.this);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyZp.setLayoutManager(linearLayoutManager);
            }
        }else {
            Toast.makeText(this, xiTongZhaoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onHuanImageFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buton_wc)
    public void onViewClicked() {
    }


}

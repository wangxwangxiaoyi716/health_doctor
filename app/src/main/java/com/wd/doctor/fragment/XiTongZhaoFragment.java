package com.wd.doctor.fragment;

import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bw.movie.base.BaseFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.SimpleBannerInfo;
import com.wd.doctor.R;
import com.wd.doctor.adapter.HuanImageAdapter;
import com.wd.doctor.bean.XiTongZhaoBean;
import com.wd.doctor.contract.HuanImgContract;
import com.wd.doctor.presenter.HuanImagePresenter;

import java.util.AbstractList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/*
 *@auther:王晓义
 *@Date: 2019/12/20
 *@Time:18:55
 *@Description:
 **/
public class XiTongZhaoFragment extends BaseFragment<HuanImagePresenter> implements HuanImgContract.Iview {

    @BindView(R.id.buton_wc)
    Button butonWc;
    @BindView(R.id.imqu_xb_xbannerone)
    XBanner imquXbXbannerone;
    private String imagePic;

    @Override
    protected HuanImagePresenter providePresenter() {
        return new HuanImagePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.xitongzhao_fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.onHuanImagePresenter();
    }

    @Override
    public void onHuanImageSuccess(XiTongZhaoBean xiTongZhaoBean) {
        //系统照片
        if (xiTongZhaoBean.getStatus().equals("0000")) {
            List<XiTongZhaoBean.ResultBean> result = xiTongZhaoBean.getResult();
            if (result != null) {


                if (!result.isEmpty()) {
                    imquXbXbannerone.setBannerData(R.layout.fresco_query, new AbstractList<SimpleBannerInfo>() {
                        @Override
                        public SimpleBannerInfo get(int index) {
                            return null;
                        }

                        @Override
                        public int size() {
                            return result.size();
                        }
                    });
                    imquXbXbannerone.loadImage(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, Object model, View view, int position) {
                            SimpleDraweeView fresco_sdv_freone = view.findViewById(R.id.fresco_sdv_freone);
                            imagePic = result.get(position).getImagePic();
                            Uri parse = Uri.parse(imagePic);
                            fresco_sdv_freone.setImageURI(parse);
                        }
                    });
                }
            }
        } else {
            Toast.makeText(getActivity(), xiTongZhaoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHuanImageFliuse(String e) {

    }

    @OnClick(R.id.buton_wc)
    public void onViewClicked() {
        getActivity().finish();
    }
}

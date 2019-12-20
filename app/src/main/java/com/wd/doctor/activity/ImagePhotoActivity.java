package com.wd.doctor.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.wd.doctor.R;
import com.wd.doctor.fragment.ShangChuanZhaoFragment;
import com.wd.doctor.fragment.XiTongZhaoFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagePhotoActivity extends BaseActivity {
    public static final String TAG = "ImagePhotoActivity";
    @BindView(R.id.view_ge)
    ViewPager viewGe;
    @BindView(R.id.radio_but01)
    RadioButton radioBut01;
    @BindView(R.id.radio_but02)
    RadioButton radioBut02;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

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

        ArrayList<Fragment> list = new ArrayList<>();

        list.add(new XiTongZhaoFragment());
        list.add(new ShangChuanZhaoFragment());

        viewGe.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        viewGe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getId()){
                    case R.id.radio_but01:
                        viewGe.setCurrentItem(0);
                        break;
                    case R.id.radio_but02:
                        viewGe.setCurrentItem(1);
                        break;
                }
            }
        });

        viewGe.setOffscreenPageLimit(2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }



}

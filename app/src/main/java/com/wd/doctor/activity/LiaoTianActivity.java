package com.wd.doctor.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiaoTianActivity extends BaseActivity {
    @BindView(R.id.sim_wenzhen_fanhui)
    SimpleDraweeView simWenzhenFanhui;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.liaotian_recy)
    RecyclerView liaotianRecy;
    @BindView(R.id.sim_yuyin)
    ImageView simYuyin;
    @BindView(R.id.ed_liaotian)
    EditText edLiaotian;
    @BindView(R.id.voice_text)
    TextView voiceText;
    @BindView(R.id.sim_biaoqing)
    ImageView simBiaoqing;
    @BindView(R.id.sim_liaotianzp)
    ImageView simLiaotianzp;
    @BindView(R.id.emotion_fa)
    ImageView emotionFa;
    @BindView(R.id.liaotian_linner)
    LinearLayout liaotianLinner;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_liao_tian;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sim_wenzhen_fanhui, R.id.liaotian_linner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_wenzhen_fanhui:
                finish();
                break;
            case R.id.liaotian_linner:
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                break;
        }
    }
}

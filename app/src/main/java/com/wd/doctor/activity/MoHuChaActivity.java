package com.wd.doctor.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.ToastUtils;
import com.bw.movie.app.App;
import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.MoHuChaXunAdapter;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.contract.MoHuChaContract;
import com.wd.doctor.presenter.MoHuChaPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoHuChaActivity extends BaseActivity<MoHuChaPresenter> implements MoHuChaContract.Iview {

    @BindView(R.id.fanhui_text)
    SimpleDraweeView fanhuiText;
    @BindView(R.id.ed_mohucha)
    EditText edMohucha;
    @BindView(R.id.but_bingquanshou)
    Button butBingquanshou;
    @BindView(R.id.recy_modainying)
    RecyclerView recyModainying;
    @BindView(R.id.include_img)
    SimpleDraweeView includeImg;
    @BindView(R.id.include_mao)
    RelativeLayout includeRelate;

    @Override
    protected MoHuChaPresenter providePresenter() {
        return new MoHuChaPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mo_hu_cha;
    }

    @Override
    protected void initData() {
        super.initData();

        edMohucha.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) App.getAppContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(MoHuChaActivity.this
                                            .getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    if (edMohucha.getText().toString().isEmpty()) {
                        ToastUtils.show("搜索栏不能为空！");
                    } else {

                    }
                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public void onMoHuChaSuccess(SearchSickCircleBean searchSickCircleBean) {
        //模糊查询
        if (searchSickCircleBean.getStatus().equals("0000")) {
            List<SearchSickCircleBean.ResultBean> result = searchSickCircleBean.getResult();
            if (result != null) {
                if (result.isEmpty()) {
                    recyModainying.setVisibility(View.GONE);
                    includeRelate.setVisibility(View.VISIBLE);
                } else {
                    recyModainying.setVisibility(View.VISIBLE);
                    includeRelate.setVisibility(View.GONE);
                    MoHuChaXunAdapter moHuChaXunAdapter = new MoHuChaXunAdapter(MoHuChaActivity.this, result);
                    recyModainying.setAdapter(moHuChaXunAdapter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoHuChaActivity.this);
                    recyModainying.setLayoutManager(linearLayoutManager);
                }
            }

        } else {
            Toast.makeText(this, searchSickCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMoHuFliuse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui_text, R.id.but_bingquanshou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui_text:
                finish();
                break;
            case R.id.but_bingquanshou:
                String mohu = edMohucha.getText().toString();
                mpresenter.onMoHuChaPresenter(mohu);
                if (mohu != null) {
                    includeRelate.setVisibility(View.GONE);
                    recyModainying.setVisibility(View.VISIBLE);
                } else {
                    recyModainying.setVisibility(View.GONE);
                    includeRelate.setVisibility(View.VISIBLE);


                }

                break;
        }
    }


}

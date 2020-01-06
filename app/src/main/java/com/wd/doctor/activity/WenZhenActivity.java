package com.wd.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.WhenZhenLeiBiaoAdapter;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.FaXinXiBean;
import com.wd.doctor.bean.JieShuWhenZhenBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.contract.WenZhenContract;
import com.wd.doctor.presenter.WenZhenPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WenZhenActivity extends BaseActivity<WenZhenPresenter> implements WenZhenContract.Iview {

    @BindView(R.id.sim_fanhuiwenleibiao_view)
    SimpleDraweeView sim_fanhuiwenleibiao_view;
    @BindView(R.id.wenzhen_recy)
    RecyclerView wenzhenRecy;
    @BindView(R.id.inc_img)
    SimpleDraweeView incImg;
    @BindView(R.id.include_wenzhen)
    TextView include_wenzhen;
    @BindView(R.id.include_ke_wenzhen)
    RelativeLayout includeKeWenzhen;
    private SharedPreferences sp;
    private int id;
    private String s;

    @Override
    protected WenZhenPresenter providePresenter() {
        return new WenZhenPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_wen_zhen;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
        mpresenter.onWenZhenPresenter(id + "", s);


    }

    @Override
    public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {
        //问诊列表
        if (wenZhenLeiBiaoBean.getStatus().equals("0000")) {
            List<WenZhenLeiBiaoBean.ResultBean> result = wenZhenLeiBiaoBean.getResult();
            if (result != null) {
                if (result.isEmpty()) {
                    wenzhenRecy.setVisibility(View.GONE);
                    includeKeWenzhen.setVisibility(View.VISIBLE);
                } else {
                    wenzhenRecy.setVisibility(View.VISIBLE);
                    includeKeWenzhen.setVisibility(View.GONE);
                    WhenZhenLeiBiaoAdapter whenZhenLeiBiaoAdapter = new WhenZhenLeiBiaoAdapter(WenZhenActivity.this, result);
                    wenzhenRecy.setAdapter(whenZhenLeiBiaoAdapter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WenZhenActivity.this);
                    wenzhenRecy.setLayoutManager(linearLayoutManager);
                    whenZhenLeiBiaoAdapter.setonclick(new WhenZhenLeiBiaoAdapter.SetOnclciklistnner() {
                        @Override
                        public void click(int recordid) {
                            mpresenter.onJieShuWenZhenPresenter(id + "", s, recordid + "");
                        }
                    });
                }

            }
        } else {
            Toast.makeText(this, wenZhenLeiBiaoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFaXinXiSuccess(FaXinXiBean faXinXiBean) {

    }

    @Override
    public void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean) {

    }

    @Override
    public void onJieShuWenZhenSuccess(JieShuWhenZhenBean jieShuWhenZhenBean) {
        //结束问诊
        if (jieShuWhenZhenBean.getStatus().equals("0000")) {
            Toast.makeText(this, jieShuWhenZhenBean.getMessage(), Toast.LENGTH_SHORT).show();
            mpresenter.onWenZhenPresenter(id + "", s);
        }
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

    @OnClick(R.id.sim_fanhuiwenleibiao_view)
    public void onViewClicked() {
        Intent intent = new Intent(WenZhenActivity.this, HomeActivity.class);
        startActivity(intent);
    }


}

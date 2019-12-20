package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.contract.RuZhuContract;
import com.wd.doctor.presenter.RuZhuPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RuZhuActivity extends BaseActivity<RuZhuPresenter> implements RuZhuContract.Iview {

    @BindView(R.id.ed_ruzhuyx)
    EditText edRuzhuyx;
    @BindView(R.id.ed_ruzhuyzm)
    EditText edRuzhuyzm;
    @BindView(R.id.ed_ruzhupwd)
    EditText edRuzhupwd;
    @BindView(R.id.ed_ruzhupwd2)
    EditText edRuzhupwd2;
    @BindView(R.id.but_net)
    Button butNet;
    @BindView(R.id.huoqu_yzm)
    Button huoquYzm;

    @Override
    protected RuZhuPresenter providePresenter() {
        return new RuZhuPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ru_zhu;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public void onRuZhuSuccess(ApplyJoinBean applyJoinBean) {
        //入驻
        if (applyJoinBean.getStatus().equals("0000")) {
            Toast.makeText(this, "入驻成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, applyJoinBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRuZhuFiluse(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }




    @OnClick({R.id.huoqu_yzm, R.id.but_net})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huoqu_yzm:
                String yzm = edRuzhuyzm.getText().toString();
                break;
            case R.id.but_net:
                String yx = edRuzhuyx.getText().toString();
                String hqyzm = edRuzhuyzm.getText().toString();
                String pwd1 = edRuzhupwd.getText().toString();
                String pwd2 = edRuzhupwd2.getText().toString();

                if (yx.isEmpty() || hqyzm.isEmpty() || pwd1.isEmpty() || pwd2.isEmpty()){
                    Toast.makeText(this, "邮箱，验证码，密码，再次确认密码，不可以为空", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(RuZhuActivity.this, ShenQingActivity.class);
                    startActivity(intent);
                }


                break;
        }
    }
}

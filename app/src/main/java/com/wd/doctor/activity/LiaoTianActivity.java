package com.wd.doctor.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.adapter.LiaoTianAdapter;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.EventBusBean;
import com.wd.doctor.bean.FaXinXiBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.contract.WenZhenContract;
import com.wd.doctor.presenter.WenZhenPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.MessageContent;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;

public class LiaoTianActivity extends BaseActivity<WenZhenPresenter> implements WenZhenContract.Iview {
    @BindView(R.id.sim_wenzhenliaotian_fanhui)
    SimpleDraweeView sim_wenzhenliaotian_fanhui;
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
    @BindView(R.id.linner_editex)
    LinearLayout linnerEditex;
    private String nickName;
    private SharedPreferences sp;
    private int userId;
    private int recordId;
    private String s;
    private int id;
    private String shurukuang;
    private String userName;
    private List<ChaXinXiBean.ResultBean> result;


    @Override
    protected WenZhenPresenter providePresenter() {
        return new WenZhenPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_liao_tian;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    liaotianRecy.scrollToPosition(result.size() - 1);
                    break;
            }
        }
    };


    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        id = sp.getInt("id", 0);
        s = sp.getString("s", null);
        Intent intent = getIntent();
        recordId = intent.getIntExtra("recordId", 0);
        userId = intent.getIntExtra("userId", 0);

        //EventBus传值
        EventBus.getDefault().postSticky(new EventBusBean(userId));

        //标题名字
        nickName = intent.getStringExtra("nickName");
        //查询聊天记录
        mpresenter.onChaXinXiModel(id + "", s, recordId + "", "1", "20");
        titleName.setText(nickName);
        //注册一个接受的广播
        JMessageClient.registerEventReceiver(this);


        edLiaotian.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //判断输入框是否有值，又值就显示发送图片
                String shuru = edLiaotian.getText().toString();
                if (shuru != null) {
                    if (shuru.isEmpty()) {
                        emotionFa.setVisibility(View.GONE);
                    } else {
                        emotionFa.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }


    //接受消息的事件
    public void onEventMainThread(MessageEvent event) {
        Message msg = event.getMessage();
        switch (msg.getContentType()) {
            case text:
                // 处理文字消息
                TextContent textContent = (TextContent) msg.getContent();
                textContent.getText();
                mpresenter.onChaXinXiModel(id + "", s, recordId + "", "1", "10");
                break;
        }
    }

    @Override
    public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {

    }

    @Override
    public void onFaXinXiSuccess(FaXinXiBean faXinXiBean) {
        //发消息
        if (faXinXiBean.getStatus().equals("0000")) {
            //查询聊天记录
            mpresenter.onChaXinXiModel(id + "", s, recordId + "", "1", "10");
            Toast.makeText(this, faXinXiBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean) {
        //查信息
        if (chaXinXiBean.getStatus().equals("0000")) {
            result = chaXinXiBean.getResult();
            if (result != null) {
                //适配器
                LiaoTianAdapter liaoTianAdapter = new LiaoTianAdapter(LiaoTianActivity.this, result);
                liaotianRecy.setAdapter(liaoTianAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LiaoTianActivity.this);
                linearLayoutManager.setStackFromEnd(true);
                liaotianRecy.setLayoutManager(linearLayoutManager);
                linearLayoutManager.setReverseLayout(true);//布局反向
                linearLayoutManager.setStackFromEnd(true);//数据反向


                linnerEditex.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edLiaotian.requestFocus();
                        showSoftInput(LiaoTianActivity.this, edLiaotian);
                        handler.sendEmptyMessageDelayed(0, 250);
                    }
                });


                liaotianRecy.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        hideSoftInput(LiaoTianActivity.this, edLiaotian);
                        return false;
                    }
                });
            }
        } else {
            Toast.makeText(this, chaXinXiBean.getMessage(), Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.sim_wenzhenliaotian_fanhui, R.id.liaotian_linner, R.id.sim_yuyin, R.id.sim_biaoqing, R.id.sim_liaotianzp, R.id.emotion_fa})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sim_wenzhenliaotian_fanhui:
                finish();
                break;
            case R.id.liaotian_linner:
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                break;
            case R.id.sim_yuyin:
                break;
            case R.id.sim_biaoqing:
                break;
            case R.id.sim_liaotianzp:
                break;
            case R.id.emotion_fa:
                Intent intent = getIntent();
                userName = intent.getStringExtra("userName");
                //发消息
                shurukuang = edLiaotian.getText().toString();
                mpresenter.onFaXinXiModel(id + "", s, recordId + "", shurukuang, "1", userId + "");


                Conversation con = Conversation.createSingleConversation(userName, "c7f6a1d56cb8da740fd18bfa");
                MessageContent content = new TextContent(shurukuang);
                //创建一条消息
                Message message = con.createSendMessage(content);
                //发送消息
                JMessageClient.sendMessage(message);
                edLiaotian.setText("");
                break;
        }
    }


    public static void showSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    public static void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }


}

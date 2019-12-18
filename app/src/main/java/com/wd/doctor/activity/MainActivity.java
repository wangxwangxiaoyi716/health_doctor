package com.wd.doctor.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.wd.doctor.R;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;

public class MainActivity extends BaseActivity {

    private Intent intent;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            intent = new Intent(MainActivity.this, DengActivity.class);
            startActivity(intent);
            finish();
        }

    };

    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = 0;
            handler.sendMessage(message);
        }
    };
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        timer.schedule(timerTask,3000);
    }
}

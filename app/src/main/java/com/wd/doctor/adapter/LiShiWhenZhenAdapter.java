package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.activity.BingXiangQingActivity;
import com.wd.doctor.activity.PingJiaXiangQingActivity;
import com.wd.doctor.activity.WenZhenJiLuActivity;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.LiShiWenZhenBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:13:52
 *@Description:
 **/
public class LiShiWhenZhenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<LiShiWenZhenBean.ResultBean> list;
    private View inflate;

    public LiShiWhenZhenAdapter(Context context, List<LiShiWenZhenBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.lishiwenzhen_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyList){
            ((MyList) holder).wenzhen_sim.setImageURI(list.get(position).getUserHeadPic());
            ((MyList) holder).text_wenzhen_name.setText(list.get(position).getNickName());
            Date date = new Date(list.get(position).getInquiryTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((MyList) holder).text_wenzhen_time.setText(simpleDateFormat.format(date));

            ((MyList) holder).but_chakanjilu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int userId = list.get(position).getUserId();
                    Intent intent = new Intent(context, WenZhenJiLuActivity.class);
                    intent.putExtra("userId",userId);
                    context.startActivity(intent);
                }
            });

            ((MyList) holder).but_chakanpingjia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int recordId = list.get(position).getRecordId();
                    Intent intent = new Intent(context, PingJiaXiangQingActivity.class);
                    intent.putExtra("recordId",recordId);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyList extends RecyclerView.ViewHolder{
        SimpleDraweeView wenzhen_sim;
        TextView text_wenzhen_name,text_wenzhen_time;
        Button but_chakanjilu,but_chakanpingjia;
        public MyList(@NonNull View itemView) {
            super(itemView);
            wenzhen_sim = itemView.findViewById(R.id.wenzhen_sim);
            text_wenzhen_name = itemView.findViewById(R.id.text_wenzhen_name);
            but_chakanjilu = itemView.findViewById(R.id.but_chakanjilu);
            text_wenzhen_time = itemView.findViewById(R.id.text_wenzhen_time);
            but_chakanpingjia = itemView.findViewById(R.id.but_chakanpingjia);
        }
    }
}

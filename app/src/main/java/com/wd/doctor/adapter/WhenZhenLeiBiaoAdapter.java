package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.activity.BingXiangQingActivity;
import com.wd.doctor.activity.LiaoTianActivity;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;

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
public class WhenZhenLeiBiaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<WenZhenLeiBiaoBean.ResultBean> list;
    private View inflate;


    public WhenZhenLeiBiaoAdapter(Context context, List<WenZhenLeiBiaoBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.wenzhenleibiao_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyList){
            ((MyList) holder).wenzhen_sim.setImageURI(list.get(position).getUserHeadPic());
            ((MyList) holder).text_namemz.setText(list.get(position).getNickName());
            ((MyList) holder).text_info.setText(list.get(position).getLastContent());
            Date date = new Date(list.get(position).getInquiryTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((MyList) holder).text_timeriqi.setText(simpleDateFormat.format(date));

            if (list.get(position).getStatus() == 1) {
                ((MyList) holder).questioning_prompt.setVisibility(View.GONE);//不显示提示(小红点)
            } else {
                ((MyList) holder).questioning_prompt.setVisibility(View.VISIBLE);//显示提示(小红点)
            }

            ((MyList) holder).relativelayout_whenzhen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int recordId = list.get(position).getRecordId();
                    int userId = list.get(position).getUserId();
                    String userName = list.get(position).getUserName();
                    String nickName = list.get(position).getNickName();
                    Intent intent = new Intent(context, LiaoTianActivity.class);
                    intent.putExtra("recordId",recordId);
                    intent.putExtra("userId",userId);
                    intent.putExtra("nickName",nickName);
                    intent.putExtra("userName",userName);
                    context.startActivity(intent);
                }
            });

            ((MyList) holder).quxiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setOnclciklistnner.click(list.get(position).getRecordId());
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
        TextView text_info,text_timeriqi,text_namemz;
        RelativeLayout relativelayout_whenzhen;
        Button quxiao;
        ImageView questioning_prompt;

        public MyList(@NonNull View itemView) {
            super(itemView);
            relativelayout_whenzhen = itemView.findViewById(R.id.relativelayout_whenzhen);
            wenzhen_sim = itemView.findViewById(R.id.wenzhen_sim);
            text_namemz = itemView.findViewById(R.id.text_namemz);
            text_timeriqi = itemView.findViewById(R.id.text_timeriqi);
            text_info = itemView.findViewById(R.id.text_info);
            quxiao = itemView.findViewById(R.id.quxiao);
            questioning_prompt = itemView.findViewById(R.id.questioning_prompt);
        }
    }

    public SetOnclciklistnner setOnclciklistnner;

    public void setonclick(SetOnclciklistnner setOnclciklistnner){
        this.setOnclciklistnner = setOnclciklistnner;
    }

    public interface SetOnclciklistnner{
        void click(int recordid);
    }
}

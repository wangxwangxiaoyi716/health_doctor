package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.activity.BingXiangQingActivity;
import com.wd.doctor.bean.FindSickCircleListBean;
import com.wd.doctor.bean.SearchSickCircleBean;

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
public class MoHuChaXunAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<SearchSickCircleBean.ResultBean> list;
    private View inflate;

    public MoHuChaXunAdapter(Context context, List<SearchSickCircleBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.mohuchaxun_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyList){
            ((MyList) holder).text_nametitile.setText(list.get(position).getTitle());
            ((MyList) holder).text_time.setText(list.get(position).getDetail());
            Date date = new Date(list.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((MyList) holder).riqi_text.setText(simpleDateFormat.format(date));

            ((MyList) holder).layout_linner01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BingXiangQingActivity.class);
                    int sickCircleId = list.get(position).getSickCircleId();
                    intent.putExtra("sickCircleId",sickCircleId);
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
        TextView text_nametitile,text_time,riqi_text;
        RelativeLayout layout_linner01;

        public MyList(@NonNull View itemView) {
            super(itemView);
            text_nametitile = itemView.findViewById(R.id.text_nametitile);
            text_time = itemView.findViewById(R.id.text_time);
            riqi_text = itemView.findViewById(R.id.riqi_text);
            layout_linner01 = itemView.findViewById(R.id.layout_linner01);
        }
    }
}

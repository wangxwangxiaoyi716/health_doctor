package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.activity.BingXiangQingActivity;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.FindSickCircleListBean;

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
public class FindSickCircleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<FindSickCircleListBean.ResultBean> list;
    private View inflate;

    public FindSickCircleListAdapter(Context context, List<FindSickCircleListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.findsickcirclelist_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyList){
            ((MyList) holder).text_itile.setText(list.get(position).getTitle());
            ((MyList) holder).text_tiao.setText(list.get(position).getDetail());
            Date date = new Date(list.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((MyList) holder).text_time.setText(simpleDateFormat.format(date));


            ((MyList) holder).relative_layout.setOnClickListener(new View.OnClickListener() {
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
        TextView text_itile,text_tiao,text_time;
        RelativeLayout relative_layout;
        public MyList(@NonNull View itemView) {
            super(itemView);
            text_itile = itemView.findViewById(R.id.text_itile);
            text_tiao = itemView.findViewById(R.id.text_tiao);
            text_time = itemView.findViewById(R.id.text_time);
            relative_layout = itemView.findViewById(R.id.relative_layout);
        }
    }
}

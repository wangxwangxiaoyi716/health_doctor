package com.wd.doctor.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.activity.HuanZheXinXIActivity;
import com.wd.doctor.bean.ChaXinXiBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:13:52
 *@Description:
 **/
public class WenZhenJiLuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<ChaXinXiBean.ResultBean> list;
    private View inflate;
    public final int ONE = 0;
    public final int TWO = 1;

    public WenZhenJiLuAdapter(Context context, List<ChaXinXiBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            Log.d("MyAdapter", "条目一");
            View view = View.inflate(context, R.layout.wenzhenjilu_left_adapter, null);
            return new LiaoLeft(view);
        } else if (viewType == TWO) {
            Log.d("MyAdapter", "条目二");
            View view1 = View.inflate(context, R.layout.wenzhenjilu_right_adapter, null);
            return new LiaoRight(view1);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case ONE:
                if (holder instanceof LiaoLeft){
                    ((LiaoLeft) holder).sim_liao_zphuanzhe.setImageURI(list.get(position).getUserHeadPic());
                    ((LiaoLeft) holder).text_liao1huanzhe.setText(list.get(position).getContent());


                    ((LiaoLeft) holder).sim_liao_zphuanzhe.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, HuanZheXinXIActivity.class);
                            context.startActivity(intent);
                        }
                    });
                }
                break;
            case TWO:
                if (holder instanceof LiaoRight){
                    ((LiaoRight) holder).sim_liao_imagedocior.setImageURI(list.get(position).getDoctorHeadPic());
                    ((LiaoRight) holder).text_liao2docior.setText(list.get(position).getContent());
                }
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        int direction = list.get(position).getDirection();
        if (direction ==1){
            return TWO;
        }else if (direction==2){
            return ONE;
        }
        return 0;
    }

    class LiaoLeft extends RecyclerView.ViewHolder{
        SimpleDraweeView sim_liao_zphuanzhe;
        TextView text_liao1huanzhe;

        public LiaoLeft(@NonNull View itemView) {
            super(itemView);
            sim_liao_zphuanzhe = itemView.findViewById(R.id.sim_liao_zphuanzhe);
            text_liao1huanzhe = itemView.findViewById(R.id.text_liao1huanzhe);
        }
    }

    class LiaoRight extends RecyclerView.ViewHolder{
        SimpleDraweeView sim_liao_imagedocior;
        TextView text_liao2docior;
        public LiaoRight(@NonNull View itemView) {
            super(itemView);
            sim_liao_imagedocior = itemView.findViewById(R.id.sim_liao_imagedocior);
            text_liao2docior = itemView.findViewById(R.id.text_liao2docior);
        }
    }


}

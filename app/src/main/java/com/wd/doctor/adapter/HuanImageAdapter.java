package com.wd.doctor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.XiTongZhaoBean;

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
public class HuanImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<XiTongZhaoBean.ResultBean> list;
    private View inflate;

    public HuanImageAdapter(Context context, List<XiTongZhaoBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.xitongimage_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyList){
            ((MyList) holder).simzp.setImageURI(list.get(position).getImagePic());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyList extends RecyclerView.ViewHolder{
        SimpleDraweeView simzp;

        public MyList(@NonNull View itemView) {
            super(itemView);
            simzp = itemView.findViewById(R.id.simzp);
        }
    }
}

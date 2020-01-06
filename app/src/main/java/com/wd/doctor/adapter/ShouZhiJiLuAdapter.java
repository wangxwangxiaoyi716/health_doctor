package com.wd.doctor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDepartmentBean;
import com.wd.doctor.bean.ShouZhiJiLuBean;

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
public class ShouZhiJiLuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<ShouZhiJiLuBean.ResultBean> list;
    private View inflate;

    public ShouZhiJiLuAdapter(Context context, List<ShouZhiJiLuBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.shouzhijilu_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyList) {
            ((MyList) holder).text_money.setText("+"+list.get(position).getMoney()+"H币");
            Date date = new Date(list.get(position).getRecordTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ((MyList) holder).text_time_shouzhijilu.setText(simpleDateFormat.format(date));
            int incomeType = list.get(position).getIncomeType();
            if (incomeType == 1){
                ((MyList) holder).text_type.setText("问诊");
            }else if (incomeType == 2){
                ((MyList) holder).text_type.setText("采纳建议");
            }else if (incomeType == 3){
                ((MyList) holder).text_type.setText("收礼物");
            }else if (incomeType == 4){
                ((MyList) holder).text_type.setText("提现");
            }

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyList extends RecyclerView.ViewHolder {
        TextView text_type,text_money,text_time_shouzhijilu;

        public MyList(@NonNull View itemView) {
            super(itemView);
            text_type = itemView.findViewById(R.id.text_type);
            text_money = itemView.findViewById(R.id.text_money);
            text_time_shouzhijilu = itemView.findViewById(R.id.text_time_shouzhijilu);

        }
    }


}

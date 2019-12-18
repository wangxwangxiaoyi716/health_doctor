package com.wd.doctor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.bean.FindDepartmentBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:13:52
 *@Description:
 **/
public class FindDePartMentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<FindDepartmentBean.ResultBean> list;
    private View inflate;

    public FindDePartMentAdapter(Context context, List<FindDepartmentBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = View.inflate(context, R.layout.finddepartment_adapter, null);
        return new MyList(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyList) {
            ((MyList) holder).text_ke.setText(list.get(position).getDepartmentName());
            ((MyList) holder).layout_linner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setOnclickListener.click(list.get(position).getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyList extends RecyclerView.ViewHolder {
        TextView text_ke;
        LinearLayout layout_linner;

        public MyList(@NonNull View itemView) {
            super(itemView);
            text_ke = itemView.findViewById(R.id.text_ke);
            layout_linner = itemView.findViewById(R.id.layout_linner);
        }
    }

    public SetOnclickListener setOnclickListener;

    public void setSetOnclickListener(SetOnclickListener setOnclickListener) {
        this.setOnclickListener = setOnclickListener;
    }

    public interface SetOnclickListener {
        void click(int id);
    }
}

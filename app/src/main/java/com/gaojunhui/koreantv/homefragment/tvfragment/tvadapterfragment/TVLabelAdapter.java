package com.gaojunhui.koreantv.homefragment.tvfragment.tvadapterfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.HomeTv;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class TVLabelAdapter extends RecyclerView.Adapter<TVLabelAdapter.MyViewHolder> {
    private List<HomeTv.CardBean.DataBean> list;
    private Context context;
    private View view;
    public interface ItemOnClickListener{
        void onButtonClick(View v, int position);
    }
    private ItemOnClickListener listener;
    public void setListener(ItemOnClickListener listener){
        this.listener=listener;
    }
    public TVLabelAdapter(List<HomeTv.CardBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       view= LayoutInflater.from(context).inflate(R.layout.item_home_label,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bt.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        Button bt;
        public MyViewHolder(View itemView) {
            super(itemView);
            bt= (Button) itemView.findViewById(R.id.home_tv_bt_label);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "图片被点击", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

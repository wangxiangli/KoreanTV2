package com.gaojunhui.koreantv.criclefragment.topicfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.Topic;

import java.util.List;

/**
 * Created by Youchao on 2016/7/13.
 */
public class CircleTopicAdapter extends RecyclerView.Adapter<CircleTopicAdapter.MyViewHoleder> {
    private List<Topic.ItemsBean>list;
    private Context context;
    private ItemCLickListener listener;
    public CircleTopicAdapter(List<Topic.ItemsBean> list, Context context) {
        this.list = list;
        this.context=context;
    }
   public interface ItemCLickListener{
        void onButtonClickListener(View v, int position);
    }

    public void setListener(ItemCLickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHoleder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHoleder holeder=new MyViewHoleder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_circle_topic_listitem,null));
        return holeder;
    }

    @Override
    public void onBindViewHolder(MyViewHoleder holder, int position) {
        String imgurl=list.get(position).getIcon_url();
        Glide.with(context).load(imgurl).into(holder.imageviewTv);
        holder.textviewTvname.setText("#" + list.get(position).getName() + "#");
        holder.textviewTvsumary.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHoleder extends RecyclerView.ViewHolder{
        TextView textviewTvname,textviewTvsumary;
        ImageView imageviewTv;
        ToggleButton button;
        public MyViewHoleder(View itemView) {
            super(itemView);
            textviewTvsumary= (TextView) itemView.findViewById(R.id.textview_tvsumary);
            textviewTvname= (TextView) itemView.findViewById(R.id.textview_tvname);
            imageviewTv= (ImageView) itemView.findViewById(R.id.imageview_tv);
            button= (ToggleButton) itemView.findViewById(R.id.button_attented);

        }
    }
}

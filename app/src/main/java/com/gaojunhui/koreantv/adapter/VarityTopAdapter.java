package com.gaojunhui.koreantv.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.VarityTop;

import java.util.List;

import butterknife.InjectView;

/**
 * Created by 嘉华盛世 on 2016-07-14.
 */
public class VarityTopAdapter extends RecyclerView.Adapter<VarityTopAdapter.MyViewHolder> {

    private List<VarityTop.CardBean> list;

    public VarityTopAdapter(List<VarityTop.CardBean> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_varity_top, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvVarityTopSub.setText(list.get(position).getData().get(0).getSub());
        holder.tvVarityTopTitle.setText(list.get(position).getData().get(0).getTitle()+":  ");
        holder.tvVarityTopUpdate.setText(list.get(position).getData().get(0).getUpdatetip());
        Log.i("varity", "onBindViewHolder: "+list.get(position).getData().get(0).getPic_h());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(list.get(position).getData().get(0).getPic_h()).build();
        holder.imageVarityTop.setController(controller);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvVarityTopSub,tvVarityTopTitle,tvVarityTopUpdate;
        SimpleDraweeView imageVarityTop;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvVarityTopSub= (TextView) itemView.findViewById(R.id.tv_varity_top_sub);
            tvVarityTopTitle= (TextView) itemView.findViewById(R.id.tv_varity_top_title);
            tvVarityTopUpdate= (TextView) itemView.findViewById(R.id.tv_varity_top_update);
            imageVarityTop= (SimpleDraweeView) itemView.findViewById(R.id.image_varity_top);
        }
    }
}

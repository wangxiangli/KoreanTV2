package com.gaojunhui.koreantv.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.RecommandBeans;

import java.util.List;

/**
 * Created by 嘉华盛世 on 2016-07-14.
 */
public class RecommandHotAdapter extends RecyclerView.Adapter<RecommandHotAdapter.MyViewHolder> {
    private static final String TAG = "RecommandHotAdapter";
    private List<RecommandBeans.CardBean.DataBean> list;
    public RecommandHotAdapter(List<RecommandBeans.CardBean.DataBean> list){
        this.list=list;
    }
    private ItemClickListener listener;
    public interface ItemClickListener{
        void onSuccess();
        void onFail();
    }

    public void setCallBack(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recommand_hot, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_update.setText(list.get(position).getUpdatetip());
        holder.tv_title.setText(list.get(position).getTitle());
        Log.i(TAG, "onBindViewHolder: " + list.get(position).getUpdatetip());
        Log.i(TAG, "onBindViewHolder: "+list.get(position).getTitle());
        Log.i(TAG, "onBindViewHolder: "+list.get(position).getPic_h());
        DraweeController controller= Fresco.newDraweeControllerBuilder().setUri(list.get(position).getPic_h())
                .setAutoPlayAnimations(true).build();
        holder.imageView.setController(controller);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title,tv_update;
        SimpleDraweeView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (SimpleDraweeView) itemView.findViewById(R.id.image_home_recomand_hot);
            tv_title= (TextView) itemView.findViewById(R.id.tv_home_recommand_title);
            tv_update= (TextView) itemView.findViewById(R.id.tv_home_recommand_update);

        }
    }
}

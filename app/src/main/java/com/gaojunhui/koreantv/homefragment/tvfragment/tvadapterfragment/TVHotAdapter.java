package com.gaojunhui.koreantv.homefragment.tvfragment.tvadapterfragment;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.HomeTv;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class TVHotAdapter extends RecyclerView.Adapter<TVHotAdapter.MyViewHolder> {
    private List<HomeTv.CardBean.DataBean> list;
    private Context context;
    private View view;

    public interface ItemOnClickListener{
        void onImageClick(View v,int position);
    }
    private ItemOnClickListener listener;
    public void setListener(ItemOnClickListener listener){
        this.listener=listener;
    }
    public TVHotAdapter(List<HomeTv.CardBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       view= LayoutInflater.from(context).inflate(R.layout.item_home_top3,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_nam.setText(list.get(position).getTitle());
        holder.tv_num.setText(list.get(position).getUpdatetip());
        String imagUrl=list.get(position).getPic_v();
        Uri uri=Uri.parse(imagUrl);
        DraweeController controller= Fresco.newDraweeControllerBuilder().setUri(uri)
                .setAutoPlayAnimations(true).build();
        holder.iv.setController(controller);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_num,tv_nam;
        SimpleDraweeView iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (SimpleDraweeView) itemView.findViewById(R.id.home_tv_iv);
            tv_nam= (TextView) itemView.findViewById(R.id.home_tv_tv_name);
            tv_num= (TextView) itemView.findViewById(R.id.home_tv_tv_num);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "图片被点击", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

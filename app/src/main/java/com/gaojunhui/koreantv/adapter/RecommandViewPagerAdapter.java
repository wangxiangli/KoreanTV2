package com.gaojunhui.koreantv.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gaojunhui.koreantv.bean.RecommandBeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 嘉华盛世 on 2016-07-13.
 */
public class RecommandViewPagerAdapter extends PagerAdapter {
    private List<RecommandBeans.CardBean.DataBean> list;
    private List<ImageView> imageViews;
    private List<String> text;
    private Context context;
    private TextView textView;

    public RecommandViewPagerAdapter(List<RecommandBeans.CardBean.DataBean> list,Context context){
        this.list=list;
        this.context=context;
        imageViews=new ArrayList<>();

        Log.i("--------", "RecommandViewPagerAdapter: "+list.size());
        for (int i=0;i<list.size();i++){
            ImageView imageView=new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(list.get(i).getPic_h()).into(imageView);

            imageViews.add(imageView);
        }

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));

        return imageViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView(imageViews.get(position));
    }
}

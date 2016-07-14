package com.gaojunhui.koreantv.homefragment.tvfragment;

import com.gaojunhui.koreantv.bean.HomeTv;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TvRresenterFragment implements TvContractFragment.Presenter {
    private TvContractFragment.View view;
    private TvContractFragment.Model model;
    public TvRresenterFragment(TvContractFragment.View view, TvContractFragment.Model model){
        this.view=view;
        this.model=model;
        EventBus.getDefault().register(this);
    }
    @Override
    public void init(int page,int type,int version,int channel) {
        model.init(page,type,version,channel);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sub(HomeTv tv){
        if (tv==null){
            view.onInitFail("加载出错");
        }else{
            view.onInitSucess(tv);
        }
    }
}

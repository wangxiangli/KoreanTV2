package com.gaojunhui.koreantv.homefragment.varietyfragment;

import android.util.Log;

import com.gaojunhui.koreantv.bean.VarityTop;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/7/11.
 */
public class VarietyPresenterFragment implements VarietyContractFragment.Presenter {
    private static final String TAG ="VarietyPresenterFragment" ;
    private VarietyContractFragment.Model model;
    private VarietyContractFragment.View view;

    public VarietyPresenterFragment(VarietyContractFragment.Model model, VarietyContractFragment.View view) {
        this.model = model;
        this.view = view;
        EventBus.getDefault().register(this);
    }

    @Override
    public void initVarity() {
        model.initVarity();
        Log.i(TAG, "initVarity: ");
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void varity(VarityTop varityTop){
        if (varityTop!=null){
            view.onSuccess(varityTop);
        }else {
            view.onFail("fail  lsafa ");
        }
    }
}

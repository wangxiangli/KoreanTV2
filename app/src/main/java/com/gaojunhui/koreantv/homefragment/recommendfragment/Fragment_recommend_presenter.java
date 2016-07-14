package com.gaojunhui.koreantv.homefragment.recommendfragment;

import android.util.Log;

import com.gaojunhui.koreantv.bean.RecommandBeans;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * I will not go to the same place!
 * Created by Administrator on 2016/7/11.
 */
public class Fragment_recommend_presenter implements Fragment_recommend_contract.Presenter {
    private Fragment_recommend_contract.View view;
    private Fragment_recommend_contract.Model model;

    public Fragment_recommend_presenter(Fragment_recommend_contract.View view
            , Fragment_recommend_contract.Model model) {
        Log.i("------", "Fragment_recommend_presenter: ");
        this.view = view;
        this.model = model;
        EventBus.getDefault().register(this);
    }

    @Override
    public void initHttp() {

        model.initHttp();

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventResult(RecommandBeans recommandBeans){
        if (recommandBeans==null){
            view.onFail("faillllllllll");
        }else {
            view.onSucess(recommandBeans);
        }
    }
}

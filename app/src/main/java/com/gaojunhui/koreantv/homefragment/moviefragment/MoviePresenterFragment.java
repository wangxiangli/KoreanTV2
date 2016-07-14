package com.gaojunhui.koreantv.homefragment.moviefragment;

import com.gaojunhui.koreantv.bean.HomeMovie;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MoviePresenterFragment implements MovieContractFragment.Presenter {
    private MovieContractFragment.Model model;
    private MovieContractFragment.View view;

    public MoviePresenterFragment(MovieContractFragment.Model model, MovieContractFragment.View view) {
        this.model = model;
        this.view = view;
        EventBus.getDefault().register(this);
    }

    @Override
    public void init(int page, int type, int version) {
        model.init(page, type, version);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sub(HomeMovie movie){
        if (movie==null){
            view.onInitFail("加载出错");
        }else{
            view.onInitSucess(movie);
        }
    }
}

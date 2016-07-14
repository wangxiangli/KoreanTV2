package com.gaojunhui.koreantv.homefragment.moviefragment;

import com.gaojunhui.koreantv.IBaseModel;
import com.gaojunhui.koreantv.IBasePresenter;
import com.gaojunhui.koreantv.IBaseView;
import com.gaojunhui.koreantv.bean.HomeMovie;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MovieContractFragment {
    interface View extends IBaseView{
        void onInitSucess(HomeMovie home);
        void onInitFail(String failMsg);
    }
    interface Model extends IBaseModel{
        void init(int page,int type,int version);
    }
    interface Presenter extends IBasePresenter{
        void init(int page,int type,int version);
    }
}

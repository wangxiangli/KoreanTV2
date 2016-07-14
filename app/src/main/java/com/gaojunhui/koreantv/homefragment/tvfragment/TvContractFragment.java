package com.gaojunhui.koreantv.homefragment.tvfragment;

import com.gaojunhui.koreantv.IBaseModel;
import com.gaojunhui.koreantv.IBasePresenter;
import com.gaojunhui.koreantv.IBaseView;
import com.gaojunhui.koreantv.bean.HomeTv;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TvContractFragment {
    interface View extends IBaseView{
        void onInitSucess(HomeTv home);
        void onInitFail(String failMsg);
    }
    interface Model extends IBaseModel{
        void init(int page,int type,int version,int channel);
    }
    interface Presenter extends IBasePresenter{
        void init(int page,int type,int version,int channel);
    }
}

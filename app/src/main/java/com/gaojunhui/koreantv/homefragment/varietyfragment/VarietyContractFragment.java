package com.gaojunhui.koreantv.homefragment.varietyfragment;

import com.gaojunhui.koreantv.IBaseModel;
import com.gaojunhui.koreantv.IBasePresenter;
import com.gaojunhui.koreantv.IBaseView;
import com.gaojunhui.koreantv.bean.VarityTop;

/**
 * Created by Administrator on 2016/7/11.
 */
public class VarietyContractFragment {
    interface View extends IBaseView{
        void onSuccess(VarityTop varityTop);
        void onFail(String result);
    }
    interface Model extends IBaseModel{
        void initVarity();
    }
    interface Presenter extends IBasePresenter{

        void initVarity();
    }
}

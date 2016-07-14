package com.gaojunhui.koreantv.homefragment;

import com.gaojunhui.koreantv.IBaseModel;
import com.gaojunhui.koreantv.IBasePresenter;
import com.gaojunhui.koreantv.IBaseView;

/**
 * Created by Administrator on 2016/7/11.
 */
public class HomeContractFragment {
    interface View extends IBaseView{


    }
    interface Model extends IBaseModel{

    }
    interface Presenter<View,Model> extends IBasePresenter{

    }
}

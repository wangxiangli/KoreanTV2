package com.gaojunhui.koreantv.main;

import com.gaojunhui.koreantv.IBaseModel;
import com.gaojunhui.koreantv.IBasePresenter;
import com.gaojunhui.koreantv.IBaseView;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MainContract {
    interface View extends IBaseView{}
    interface Model extends IBaseModel{}
    interface Presenter extends IBasePresenter{}
}

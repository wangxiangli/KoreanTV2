package com.gaojunhui.koreantv.criclefragment.topicfragment;

import com.gaojunhui.koreantv.IBaseModel;
import com.gaojunhui.koreantv.IBasePresenter;
import com.gaojunhui.koreantv.IBaseView;
import com.gaojunhui.koreantv.bean.Topic;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TopicContractFragment {
    interface View extends IBaseView{
       void onInitSuccess(Topic topic);
        void onInitFail(String failMsg);
    }
    interface Model extends IBaseModel{
      void init();
    }
    interface Presenter<View,Model> extends IBasePresenter{
        void init();
    }
}

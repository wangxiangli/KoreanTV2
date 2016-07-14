package com.gaojunhui.koreantv.criclefragment.topicfragment;


import com.gaojunhui.koreantv.bean.Topic;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TopicPresenterFragment implements TopicContractFragment.Presenter {
    private TopicContractFragment.View view;
    private TopicContractFragment.Model model;

    public TopicPresenterFragment(TopicContractFragment.View view, TopicContractFragment.Model model) {
        this.view = view;
        this.model = model;
        EventBus.getDefault().register(this);
    }

    @Override
    public void init() {
       model.init();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sub(Topic topic) {
        if (topic == null) {
            view.onInitFail("cuowu");
        } else {
            view.onInitSuccess(topic);
        }
    }
}

package com.gaojunhui.koreantv.criclefragment.topicfragment;

import com.gaojunhui.koreantv.httputils.HttpUtils;
import com.gaojunhui.koreantv.httputils.UrlConfig;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TopicModelFragment implements TopicContractFragment.Model {
    @Override
    public void init() {
        HttpUtils.newInstance(UrlConfig.BASE_URL).getTopic();
    }
}

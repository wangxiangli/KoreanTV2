package com.gaojunhui.koreantv.homefragment.tvfragment;

import com.gaojunhui.koreantv.httputils.HttpUtils;
import com.gaojunhui.koreantv.httputils.UrlConfig;

/**
 * Created by Administrator on 2016/7/11.
 */
public class TvModelFragment implements TvContractFragment.Model {

    @Override
    public void init(int page,int type,int version,int channel) {
        HttpUtils.newInstance(UrlConfig.TV_URL).getDataHome_tv(page, type,version,channel);
    }
}

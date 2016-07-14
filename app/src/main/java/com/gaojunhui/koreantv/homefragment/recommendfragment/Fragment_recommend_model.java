package com.gaojunhui.koreantv.homefragment.recommendfragment;

import android.util.Log;

import com.gaojunhui.koreantv.httputils.HttpUtils;
import com.gaojunhui.koreantv.httputils.UrlConfig;

/**
 * Created by Administrator on 2016/7/11.
 */
public class Fragment_recommend_model implements Fragment_recommend_contract.Model {
    private static final String TAG ="-------" ;

    @Override
    public void initHttp() {
        Log.i(TAG, "initHttp: ");
        HttpUtils.newInstance(UrlConfig.RECOMMAND_FIRST).getRecommand();
    }

}

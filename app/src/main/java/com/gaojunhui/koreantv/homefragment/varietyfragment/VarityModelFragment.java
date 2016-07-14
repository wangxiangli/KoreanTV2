package com.gaojunhui.koreantv.homefragment.varietyfragment;

import android.util.Log;

import com.gaojunhui.koreantv.httputils.HttpUtils;
import com.gaojunhui.koreantv.httputils.UrlConfig;

/**
 * Created by Administrator on 2016/7/11.
 */
public class VarityModelFragment implements VarietyContractFragment.Model {
    private static final String TAG ="VarityModelFragment" ;

    @Override
    public void initVarity() {
        Log.i(TAG, "initVarity: ");
        HttpUtils.newInstance(UrlConfig.TV_URL).getVarity();
    }

}

package com.gaojunhui.koreantv.homefragment.moviefragment;

import com.gaojunhui.koreantv.httputils.HttpUtils;
import com.gaojunhui.koreantv.httputils.UrlConfig;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MovieModelFragment implements MovieContractFragment.Model {
    @Override
    public void init(int page, int type, int version) {
        HttpUtils.newInstance(UrlConfig.MOVIE_URL).getHomeMovie(page, type,version);
    }
}

package com.gaojunhui.koreantv.httputils;


import com.gaojunhui.koreantv.bean.RecommandBeans;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by zhonghang on 16/7/11.
 */

public interface IRetrofitHttp {
    @GET("/{path}/login")
    Call<ResponseBody> login(@Path("path")
                             String path,
                             @QueryMap
                             HashMap<String, String> map);
    @GET("1")
    Call<ResponseBody> getHotDay1();
    @GET("3")
    Call<ResponseBody> getHotDay3();
    @GET("7")
    Call<ResponseBody> getHotDay7();
    @GET("30")
    Call<ResponseBody> getHotDay30();
    @GET("/v2/topics/?dt=1467342468530&de=m2+note&uid=5775e83a7019c924ee5c0b4e&os=Android&en=Wi-Fi&sdkv=2.4.0&imei=869085025409583&ak=56fcdf9f67e58e6e4c000cee&md5imei=51df316b5e9c1d255b3f0f17762e11e9&mac=68%3A3e%3A34%3A54%3Aad%3Ae6&count=300")
    Call<ResponseBody> getTopic();
    @GET("/korean/servers/Korean_Info.ashx?method=get_korean_tabchange&type=8&page=1&count=8&os=android&version=1170&channel=qq&pkgname=com.leku.hmsq")
    Call<ResponseBody> getRecommand();
    @POST("{path}?")
    Call<ResponseBody> getHomeDate(@Path("path") String path, @QueryMap() Map<String, String> params);
    @POST("{path}?")
    Call<ResponseBody> getHomeMovieDate(@Path("path") String path, @QueryMap() Map<String, String> params);
    @GET("/korean/servers/Korean_Info.ashx?method=get_korean_tabchange&type=3&page=1&count=8&os=android&version=1180&channel=wandoujia&pkgname=com.leku.hmsq")
    Call<ResponseBody> getVarity();
}

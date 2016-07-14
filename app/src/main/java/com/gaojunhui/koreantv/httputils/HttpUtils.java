package com.gaojunhui.koreantv.httputils;

import android.util.Log;

import com.alibaba.fastjson.JSON;

import com.gaojunhui.koreantv.bean.HomeMovie;
import com.gaojunhui.koreantv.bean.HomeTv;
import com.gaojunhui.koreantv.bean.RecommandBeans;
import com.gaojunhui.koreantv.bean.Topic;
import com.gaojunhui.koreantv.bean.VarityTop;


import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zhonghang on 16/7/11.
 */

public class HttpUtils {
    private static final String TAG ="varity" ;
    private IRetrofitHttp http;
    private MyHttpCallBack callBack;
    public interface MyHttpCallBack {
        void sucess();

        void fail();
    }
    private HttpUtils(String url) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();
        http = retrofit.create(IRetrofitHttp.class);
    }

    private static HttpUtils httpUtils;

    public synchronized static HttpUtils newInstance(String url) {
            httpUtils = new HttpUtils(url);

        return httpUtils;
    }

    /**
     * 圈子_话题
     */
    public void getTopic() {
        Call<ResponseBody> call = http.getTopic();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Topic topic = JSON.parseObject(response.body().string(), Topic.class);
                    EventBus.getDefault().post(topic);
                } catch (IOException e) {
                    e.printStackTrace();
                    EventBus.getDefault().post(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EventBus.getDefault().post(null);
            }
        });
    }

    /**
     * 登录
     * @param params
     * @param callBack
     */
    public void login(HashMap<String, String> params, final MyHttpCallBack callBack) {
        Call<ResponseBody> call = http.login("", params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callBack.sucess();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.fail();
            }
        });
    }

    /**
     * 首页——TV
     * /korean/servers/Korean_Info.ashx?method=get_korean_tabchange&type=2&page=1&count=8&os=android
     * &version=1180&channel=360&pkgname=com.leku.hmsq
     */
    public void getDataHome_tv(int page,int type,int version,int channel) {
        HashMap<String,String> map=new HashMap<>();
        map.put("method","get_korean_tabchange");
        map.put("type",type+"");
        map.put("page",page+"");
        map.put("count","8");
        map.put("os","android");
        map.put("version",version+"");
        map.put("channel",channel+"");
        map.put("pkgname","com.leku.hmsq");

        Call<ResponseBody> call = http.getHomeDate("/korean/servers/Korean_Info.ashx", map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    HomeTv tv = JSON.parseObject(response.body().string(), HomeTv.class);
                    EventBus.getDefault().post(tv);
                } catch (IOException e) {
                    e.printStackTrace();
                    EventBus.getDefault().post(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EventBus.getDefault().post(null);
            }
        });
    }
    /**
     * 首页——Movie
     * http://www.91hanju.com/korean/servers/Korean_Info.ashx?method=get_korean_tabchange&type=1
     * &page=1&count=8&os=android&version=1170&channel=qq&pkgname=com.leku.hmsq
     *
     */
    public void getHomeMovie(int page,int type,int version) {
        HashMap<String,String> map=new HashMap<>();
        map.put("method","get_korean_tabchange");
        map.put("type",type+"");
        map.put("page",page+"");
        map.put("count","8");
        map.put("os","android");
        map.put("version",version+"");
        map.put("channel","qq");
        map.put("pkgname","com.leku.hmsq");

        Call<ResponseBody> call = http.getHomeMovieDate("/korean/servers/Korean_Info.ashx", map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    HomeMovie movie = JSON.parseObject(response.body().string(), HomeMovie.class);
                    EventBus.getDefault().post(movie);
                } catch (IOException e) {
                    e.printStackTrace();
                    EventBus.getDefault().post(null);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EventBus.getDefault().post(null);
            }
        });
    }
    /*推荐页面*/
    public void getRecommand(){
        Call<ResponseBody> call=http.getRecommand();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("-------", "onResponse: ");
                    RecommandBeans recommandBeans=JSON.parseObject(response.body().string(),RecommandBeans.class);
                    Log.i("--------", "onResponse: "+recommandBeans.getReMsg());
                    EventBus.getDefault().post(recommandBeans);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EventBus.getDefault().post(null);
            }
        });
    }
    /*综艺top数据*/
    public void getVarity(){
        Call<ResponseBody> call=http.getVarity();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i(TAG, "onResponse: httputils");
                    VarityTop varityTop=JSON.parseObject(response.body().string(),VarityTop.class);
                    EventBus.getDefault().post(varityTop);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EventBus.getDefault().post(null);
            }
        });
    }
}

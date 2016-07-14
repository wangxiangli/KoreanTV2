package com.gaojunhui.koreantv.homefragment.moviefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.HomeMovie;
import com.gaojunhui.koreantv.homefragment.moviefragment.movieadapterfragment.MovieHomeAdapter;
import com.gaojunhui.koreantv.homefragment.moviefragment.movieadapterfragment.MovieLabelAdapter;
import com.gaojunhui.koreantv.homefragment.tvfragment.tvadapterfragment.TVHotAdapter;
import com.gaojunhui.koreantv.homefragment.tvfragment.tvadapterfragment.TVLabelAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MovieFragment extends BaseFragmen implements MovieContractFragment.View {
    @InjectView(R.id.recyclerViewNew)
    RecyclerView recyclerViewNew;
    @InjectView(R.id.textViewIdol)
    TextView textViewIdol;
    @InjectView(R.id.textViewIdolMore)
    TextView textViewIdolMore;
    @InjectView(R.id.recyclerViewIdol)
    RecyclerView recyclerViewIdol;
    @InjectView(R.id.recyclerViewMovielabel)
    RecyclerView recyclerViewMovielabel;
    @InjectView(R.id.textViewLove)
    TextView textViewLove;
    @InjectView(R.id.textViewLoveMore)
    TextView textViewLoveMore;
    @InjectView(R.id.recyclerViewLove)
    RecyclerView recyclerViewLove;
    @InjectView(R.id.textViewLacrimation)
    TextView textViewLacrimation;
    @InjectView(R.id.textViewLacrimationMore)
    TextView textViewLacrimationMore;
    @InjectView(R.id.recyclerViewLacrimation)
    RecyclerView recyclerViewLacrimation;
    @InjectView(R.id.textViewHigh)
    TextView textViewHigh;
    @InjectView(R.id.textViewHighMore)
    TextView textViewHighMore;
    @InjectView(R.id.recyclerViewHigh)
    RecyclerView recyclerViewHigh;
    @InjectView(R.id.pullToRefreshScrollViewMovie)
    PullToRefreshScrollView pullToRefreshScrollViewMovie;
    private View view;
    //电影：http://www.91hanju.com/korean/servers/Korean_Info.ashx?method=get_korean_tabchange&
    // type=1&page=1&count=8&os=android&version=1170&channel=qq&pkgname=com.leku.hmsq
    private int mPage = 1, type = 1, version = 1170;
    private MovieModelFragment mModel;
    private MoviePresenterFragment mPresenter;
    private List<HomeMovie.CardBean> totaList;
    private List<HomeMovie.CardBean.DataBean> newMovieList, idolMovieList, labelMovieList, loveMovieList, lacrimationMovieList, heignMovieList;
    private MovieHomeAdapter adapterNew,adapterIdol,adapterLove,adapterLacrimation,adapterHeigh;
    private MovieLabelAdapter adapterLabel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_movie, null);
        ButterKnife.inject(this, view);
        mModel = new MovieModelFragment();
        mPresenter = new MoviePresenterFragment(mModel, this);
        initList();//初始化List
        initAdapters();//适配
        initScrollView();//初始化下拉刷新
        scrollViewLisener();//上下拉刷新
        return view;
    }
    /**
     * 初始化上下拉刷新
     */
    private void initScrollView() {
        pullToRefreshScrollViewMovie.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshScrollViewMovie.setPullLabel("下拉刷新", PullToRefreshBase.Mode.PULL_FROM_START);
        pullToRefreshScrollViewMovie.setRefreshingLabel("正在加载...", PullToRefreshBase.Mode.PULL_FROM_START);
        pullToRefreshScrollViewMovie.setReleaseLabel("放开刷新", PullToRefreshBase.Mode.PULL_FROM_START);
        pullToRefreshScrollViewMovie.setPullLabel("上拉加载", PullToRefreshBase.Mode.PULL_FROM_END);
        pullToRefreshScrollViewMovie.setRefreshingLabel("正在加载...", PullToRefreshBase.Mode.PULL_FROM_END);
        pullToRefreshScrollViewMovie.setReleaseLabel("放开加载", PullToRefreshBase.Mode.PULL_FROM_END);
    }

    /**
     * 设置Scroll的监听事件
     */
    private void scrollViewLisener() {
        pullToRefreshScrollViewMovie.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                mPage++;
                totaList.clear();
                mPresenter.init(mPage, type, version);
                pullToRefreshScrollViewMovie.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                mPage++;
                mPresenter.init(mPage, type, version);
                pullToRefreshScrollViewMovie.onRefreshComplete();
            }
        });
    }
    /**
     * 对各个控件进行适配
     */
    private void initAdapters() {
        //最新电影的适配
        adapterNew = new MovieHomeAdapter(newMovieList, getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewNew.setLayoutManager(gridLayoutManager);
        recyclerViewNew.setAdapter(adapterNew);
        //青春偶像的适配
        adapterIdol = new MovieHomeAdapter(idolMovieList, getActivity());
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewIdol.setLayoutManager(gridLayoutManager1);
        recyclerViewIdol.setAdapter(adapterIdol);
        //标签的适配
        adapterLabel = new MovieLabelAdapter(labelMovieList, getActivity());
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 5, GridLayoutManager.VERTICAL, false);
        recyclerViewMovielabel.setLayoutManager(gridLayoutManager2);
        recyclerViewMovielabel.setAdapter(adapterLabel);
        //爱情进阶的适配
        adapterLove = new MovieHomeAdapter(loveMovieList, getActivity());
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewLove.setLayoutManager(gridLayoutManager3);
        recyclerViewLove.setAdapter(adapterLove);
        //催泪大片的适配
        adapterLacrimation = new MovieHomeAdapter(lacrimationMovieList, getActivity());
        GridLayoutManager gridLayoutManager4 = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewLacrimation.setLayoutManager(gridLayoutManager4);
        recyclerViewLacrimation.setAdapter(adapterLacrimation);
        //高分大片的适配
        adapterHeigh = new MovieHomeAdapter(heignMovieList, getActivity());
        GridLayoutManager gridLayoutManager5 = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewHigh.setLayoutManager(gridLayoutManager5);
        recyclerViewHigh.setAdapter(adapterHeigh);
    }
    /**
     * 初始化List
     */
    private void initList() {
        totaList = new ArrayList<>();
        newMovieList = new ArrayList<>();
        idolMovieList = new ArrayList<>();
        labelMovieList = new ArrayList<>();
        loveMovieList = new ArrayList<>();
        lacrimationMovieList = new ArrayList<>();
        heignMovieList = new ArrayList<>();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.init(mPage, type, version);
    }

    @Override
    public void onInitSucess(HomeMovie home) {
        totaList.addAll(home.getCard());
        newMovieList.addAll(totaList.get(0).getData());
        idolMovieList.addAll(totaList.get(1).getData());
        labelMovieList.addAll(totaList.get(2).getData());
        loveMovieList.addAll(totaList.get(3).getData());
        lacrimationMovieList.addAll(totaList.get(4).getData());
        heignMovieList.addAll(totaList.get(5).getData());
        //提醒适配器改变
        adapterNew.notifyDataSetChanged();
        adapterIdol.notifyDataSetChanged();
        adapterLove.notifyDataSetChanged();
        adapterLabel.notifyDataSetChanged();
        adapterLacrimation.notifyDataSetChanged();
        adapterHeigh.notifyDataSetChanged();
    }

    @Override
    public void onInitFail(String failMsg) {
        Toast.makeText(getActivity(), "获取数据错误", Toast.LENGTH_SHORT).show();
    }
}

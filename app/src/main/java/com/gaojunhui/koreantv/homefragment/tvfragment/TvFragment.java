package com.gaojunhui.koreantv.homefragment.tvfragment;

import android.net.Uri;
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

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.HomeTv;
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
public class TvFragment extends BaseFragmen implements TvContractFragment.View {
    @InjectView(R.id.textView_hot)
    TextView textViewHot;
    @InjectView(R.id.textView_more)
    TextView textViewMore;
    @InjectView(R.id.textView_update)
    TextView textViewUpdate;
    @InjectView(R.id.textView_more2)
    TextView textViewMore2;
    @InjectView(R.id.image_tv_head)
    SimpleDraweeView imageTvHead;
    @InjectView(R.id.recyclerView_hot)
    RecyclerView recyclerViewHot;
    @InjectView(R.id.recyclerView_updata)
    RecyclerView recyclerViewUpdata;
    @InjectView(R.id.recyclerView_top3)
    RecyclerView recyclerViewTop3;
    @InjectView(R.id.recyclerView_label)
    RecyclerView recyclerViewLabel;
    @InjectView(R.id.homePullToRefreshScrollView)
    PullToRefreshScrollView homePullToRefreshScrollView;
    private View view;
    private TvModelFragment mTv_model;
    private TvRresenterFragment mTv_presenter;
    private List<HomeTv.CardBean> totalList;
    private List<HomeTv.CardBean.DataBean> mTv_listTop3;
    private List<HomeTv.CardBean.DataBean> mTv_listHot;
    private List<HomeTv.CardBean.DataBean> mTv_listUpData;
    private List<HomeTv.CardBean.DataBean> mTv_listLabel;
    private String imagUrl_head;
    private Uri mUri;
    private DraweeController mController;
    private TVHotAdapter myAdapter_tv_top3, myAdapter_tv_hot, myAdapter_tv_upDate;
    private TVLabelAdapter myAdapter_tv_label;
    private int mPage = 1,type=2,version=1180,channel=360;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_tv, null);
        ButterKnife.inject(this, view);
        initListAndFragment();//初始化对象
        initAdapters(); //适配
        initScrollView();//初始化上下拉刷新
        scrollViewLisener();//上下啦刷新
        return view;
    }

    /**
     * 初始化上下拉刷新
     */
    private void initScrollView() {
        homePullToRefreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
        homePullToRefreshScrollView.setPullLabel("下拉刷新", PullToRefreshBase.Mode.PULL_FROM_START);
        homePullToRefreshScrollView.setRefreshingLabel("正在加载...", PullToRefreshBase.Mode.PULL_FROM_START);
        homePullToRefreshScrollView.setReleaseLabel("放开刷新", PullToRefreshBase.Mode.PULL_FROM_START);
        homePullToRefreshScrollView.setPullLabel("上拉加载", PullToRefreshBase.Mode.PULL_FROM_END);
        homePullToRefreshScrollView.setRefreshingLabel("正在加载...", PullToRefreshBase.Mode.PULL_FROM_END);
        homePullToRefreshScrollView.setReleaseLabel("放开加载", PullToRefreshBase.Mode.PULL_FROM_END);
    }

    /**
     * 设置Scroll的监听事件
     */
    private void scrollViewLisener() {
        homePullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                mPage++;
                totalList.clear();
                mTv_presenter.init(mPage,type,version,channel);
                homePullToRefreshScrollView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                mPage++;
                mTv_presenter.init(mPage,type,version,channel);
                homePullToRefreshScrollView.onRefreshComplete();
            }
        });
    }

    /**
     * 各对象的初始化
     */
    private void initListAndFragment() {
        mTv_model = new TvModelFragment();
        mTv_presenter = new TvRresenterFragment(this, mTv_model);
        totalList = new ArrayList<>();
        mTv_listTop3 = new ArrayList<>();
        mTv_listHot = new ArrayList<>();
        mTv_listUpData = new ArrayList<>();
        mTv_listLabel = new ArrayList<>();
    }

    /**
     * 对各个控件进行适配
     */
    private void initAdapters() {
        //TOP3的适配
        myAdapter_tv_top3 = new TVHotAdapter(mTv_listTop3, getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewTop3.setLayoutManager(gridLayoutManager);
        recyclerViewTop3.setAdapter(myAdapter_tv_top3);
        //热播剧场的适配
        myAdapter_tv_hot = new TVHotAdapter(mTv_listHot, getActivity());
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewHot.setLayoutManager(gridLayoutManager1);
        recyclerViewHot.setAdapter(myAdapter_tv_hot);
        //最近更新的适配
        myAdapter_tv_upDate = new TVHotAdapter(mTv_listUpData, getActivity());
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerViewUpdata.setLayoutManager(gridLayoutManager2);
        recyclerViewUpdata.setAdapter(myAdapter_tv_upDate);
        //标签选剧的适配
        myAdapter_tv_label = new TVLabelAdapter(mTv_listLabel, getActivity());
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(), 5, GridLayoutManager.VERTICAL, false);
        recyclerViewLabel.setLayoutManager(gridLayoutManager3);
        recyclerViewLabel.setAdapter(myAdapter_tv_label);
    }

    /**
     * 启动，加载头部视图
     */
    private void addImagViewHead() {
        mUri = Uri.parse(imagUrl_head);
        mController = Fresco.newDraweeControllerBuilder().setUri(mUri).setAutoPlayAnimations(true).
                build();
        imageTvHead.setController(mController);

    }

    @Override
    public void onResume() {
        super.onResume();
        mTv_presenter.init(mPage,type,version,channel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onInitSucess(HomeTv home) {
        totalList.addAll(home.getCard());
        imagUrl_head = totalList.get(0).getData().get(0).getPic_h();
        //加载头部视图
        if (imageTvHead != null) {
            addImagViewHead();
        }
        mTv_listTop3.addAll(totalList.get(1).getData());
        mTv_listHot.addAll(totalList.get(2).getData());
        mTv_listUpData.addAll(totalList.get(3).getData());
        mTv_listLabel.addAll(totalList.get(4).getData());
        myAdapter_tv_top3.notifyDataSetChanged();
        myAdapter_tv_hot.notifyDataSetChanged();
        myAdapter_tv_upDate.notifyDataSetChanged();
        myAdapter_tv_label.notifyDataSetChanged();
    }

    @Override
    public void onInitFail(String failMsg) {
        Toast.makeText(getActivity(), "获取数据错误", Toast.LENGTH_SHORT).show();
    }
}

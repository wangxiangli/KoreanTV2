package com.gaojunhui.koreantv.homefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;

import com.gaojunhui.koreantv.homefragment.homeadapterfragment.MyadapterFragment;
import com.gaojunhui.koreantv.homefragment.moviefragment.MovieFragment;
import com.gaojunhui.koreantv.homefragment.mvfragment.MvFragment;
import com.gaojunhui.koreantv.homefragment.newsfragment.NewsFragment;

import com.gaojunhui.koreantv.homefragment.recommendfragment.RecommendFragment;
import com.gaojunhui.koreantv.homefragment.tvfragment.TvFragment;
import com.gaojunhui.koreantv.homefragment.varietyfragment.VarietyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/7/11.
 */
public class HomeFragment extends BaseFragmen implements HomeContractFragment.View {
    @InjectView(R.id.toolbar_home)
    Toolbar toolbarHome;
    @InjectView(R.id.tablelayout)
    TabLayout tablelayout;
    @InjectView(R.id.viewPager_home)
    ViewPager viewPagerHome;
    private View view;
    private Fragment fragment_recommend,fragment_tv,fragment_movie,fragment_variety,fragment_mv,fragment_news;
    private List<Fragment> fragments=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        ButterKnife.inject(this, view);
        initToolbar();
        addFragmens();
        initTableLayout();

        return view;
    }

    /**
     * 创建ToolBar
     */
    private void initToolbar() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarHome);
        setHasOptionsMenu(true);//
    }

    /**
     * 创建TableLayout
     */
    private void initTableLayout() {
        MyadapterFragment myadapter_fragment=new MyadapterFragment(getActivity().getSupportFragmentManager(),fragments);
        viewPagerHome.setAdapter(myadapter_fragment);
        tablelayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablelayout.setupWithViewPager(viewPagerHome);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar_home_menu, menu);
    }

    /**
     * 填充fragments集合
     */
    public void addFragmens(){
        fragment_recommend=new RecommendFragment();
        fragment_tv=new TvFragment();
        fragment_movie=new MovieFragment();
        fragment_variety=new VarietyFragment();
        fragment_mv=new MvFragment();
        fragment_news=new NewsFragment();

        fragments.add(fragment_recommend);
        fragments.add(fragment_tv);
        fragments.add(fragment_movie);
        fragments.add(fragment_variety);
        fragments.add(fragment_mv);
        fragments.add(fragment_news);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}

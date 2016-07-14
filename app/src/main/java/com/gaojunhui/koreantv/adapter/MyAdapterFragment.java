package com.gaojunhui.koreantv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class MyAdapterFragment extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    private String[] circle_title = {"热门", "推荐", "关注", "话题"};
    public MyAdapterFragment(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return circle_title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

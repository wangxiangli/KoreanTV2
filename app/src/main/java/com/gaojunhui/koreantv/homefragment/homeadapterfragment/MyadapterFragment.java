package com.gaojunhui.koreantv.homefragment.homeadapterfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MyadapterFragment extends FragmentPagerAdapter {
    private List<Fragment> list;
    public MyadapterFragment(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "推荐";
            case 1:
                return "电视剧";
            case 2:
                return "电影";
            case 3:
                return "综艺";
            case 4:
                return "MV";
            case 5:
                return "娱乐新闻";
        }
        return null;
    }
}

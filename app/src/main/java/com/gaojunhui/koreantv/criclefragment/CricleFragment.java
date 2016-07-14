package com.gaojunhui.koreantv.criclefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gaojunhui.koreantv.adapter.MyAdapterFragment;
import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.criclefragment.attentionfragment.AttentionFragment;

import com.gaojunhui.koreantv.criclefragment.hotfragmnt.HotFragment;
import com.gaojunhui.koreantv.criclefragment.topicfragment.TopicFragment;
import com.gaojunhui.koreantv.homefragment.recommendfragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/7/11.
 */
public class CricleFragment extends BaseFragmen implements CricleContractFragment.View {
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.iv_load)
    ImageView ivLoad;
    @InjectView(R.id.vp_circle)
    ViewPager vpCircle;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cricle, null);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.iv_load)
    public void onClick() {
    }
    public void init(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HotFragment());
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new AttentionFragment());
        fragmentList.add(new TopicFragment());
        MyAdapterFragment adapter = new MyAdapterFragment(manager,fragmentList);
        vpCircle.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpCircle);
    }
}

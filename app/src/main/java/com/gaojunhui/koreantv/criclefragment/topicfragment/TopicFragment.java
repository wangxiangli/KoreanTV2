package com.gaojunhui.koreantv.criclefragment.topicfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.bean.Topic;
import com.gaojunhui.koreantv.criclefragment.topicfragment.adapter.CircleTopicAdapter;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016/7/11.
 */
public class TopicFragment extends BaseFragmen implements TopicContractFragment.View {

    @InjectView(R.id.listview_topic)
    RecyclerView listviewTopic;
    private View view;
    private TopicContractFragment.Presenter mPresenter;
    private TopicContractFragment.Model mModel;
    private List<Topic.ItemsBean> list_topic;
    private CircleTopicAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cricle_topic, null);
        ButterKnife.inject(this, view);
        mModel = new TopicModelFragment();
        mPresenter = new TopicPresenterFragment(this, mModel);
        list_topic = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        listviewTopic.setLayoutManager(manager);
        listviewTopic.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).color(Color.argb(50,192,192,192))
                .build());
        adapter = new CircleTopicAdapter(list_topic, getActivity());
        listviewTopic.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.init();
    }

    @Override
    public void onInitSuccess(Topic topic) {
        list_topic.addAll(topic.getItems());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onInitFail(String failMsg) {
        Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}

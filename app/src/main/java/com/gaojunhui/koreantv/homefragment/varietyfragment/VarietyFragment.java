package com.gaojunhui.koreantv.homefragment.varietyfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.adapter.VarityTopAdapter;
import com.gaojunhui.koreantv.bean.VarityTop;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/7/11.
 */
public class VarietyFragment extends BaseFragmen implements VarietyContractFragment.View {
    private static final String TAG = "VarietyFragment";
    @InjectView(R.id.recycleVeiw_varity_top)
    RecyclerView recycleVeiwVarityTop;
    @InjectView(R.id.tv_varity_more)
    TextView tvVarityMore;
    @InjectView(R.id.recyclerView_varity_bottom)
    RecyclerView recyclerViewVarityBottom;
    @InjectView(R.id.ptrlayout_varity)
    PtrClassicFrameLayout ptrlayoutVarity;
    private View view;
    private VarietyContractFragment.Presenter presenter;
    private VarietyContractFragment.Model model;
    private List<VarityTop.CardBean> topList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_variety, null);
        ButterKnife.inject(this, view);
        initData();
        initPtr();
        initHttpVarity();

        return view;
    }

    private void initData() {
        topList=new ArrayList<>();
    }

    private void initHttpVarity() {
        model=new VarityModelFragment();
        presenter=new VarietyPresenterFragment(model,this);
        presenter.initVarity();
        Log.i(TAG, "initHttpVarity:   start");
    }

    private void initPtr() {
        ptrlayoutVarity.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrlayoutVarity.refreshComplete();
                    }
                }, 1000);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onSuccess(VarityTop varityTop) {
        topList=varityTop.getCard();
        Log.i(TAG, "onSuccess: "+topList.size());
        initRecyclerView();
    }

    @Override
    public void onFail(String result) {
        Log.i(TAG, "onFail: ");
    }

    private void initRecyclerView() {
        VarityTopAdapter topAdapter=new VarityTopAdapter(topList);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycleVeiwVarityTop.setLayoutManager(manager);
        recycleVeiwVarityTop.setAdapter(topAdapter);
    }
}

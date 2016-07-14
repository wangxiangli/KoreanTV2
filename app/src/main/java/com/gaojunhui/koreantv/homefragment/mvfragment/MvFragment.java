package com.gaojunhui.koreantv.homefragment.mvfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MvFragment extends BaseFragmen implements MvContractFragment.View{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_mv,null);
        return view;
    }
}

package com.gaojunhui.koreantv.criclefragment.hotfragmnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * Created by Administrator on 2016/7/11.
 */
public class HotFragment extends BaseFragmen implements HotContractFragment.View {
    @InjectView(R.id.rb_1day)
    RadioButton rb1day;
    @InjectView(R.id.rb_3day)
    RadioButton rb3day;
    @InjectView(R.id.rb_7day)
    RadioButton rb7day;
    @InjectView(R.id.rb_30day)
    RadioButton rb30day;
    @InjectView(R.id.ptr_hot)
    PtrClassicFrameLayout ptrHot;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cricle_hot, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.rb_1day, R.id.rb_3day, R.id.rb_7day, R.id.rb_30day})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_1day:
                break;
            case R.id.rb_3day:
                break;
            case R.id.rb_7day:
                break;
            case R.id.rb_30day:
                break;
        }
    }
}

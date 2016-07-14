package com.gaojunhui.koreantv.homefragment.recommendfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gaojunhui.koreantv.BaseFragmen;
import com.gaojunhui.koreantv.R;
import com.gaojunhui.koreantv.adapter.RecommandHotAdapter;
import com.gaojunhui.koreantv.adapter.RecommandViewPagerAdapter;
import com.gaojunhui.koreantv.adapter.ViewPagerForMV;
import com.gaojunhui.koreantv.bean.RecommandBeans;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;


/**
 * Created by Administrator on 2016/7/11.
 */
public class RecommendFragment extends BaseFragmen implements Fragment_recommend_contract.View {
    private static final String TAG = "-------";
    @InjectView(R.id.recyclerView_recommand_hot)
    RecyclerView recyclerViewRecommandHot;
    @InjectView(R.id.recyclerView_recommand_varity)
    RecyclerView recyclerViewRecommandVarity;
    @InjectView(R.id.recyclerView_recommand_film)
    RecyclerView recyclerViewRecommandFilm;
    @InjectView(R.id.viewpager_recommand_mv)
    ViewPager viewpagerRecommandMv;
    @InjectView(R.id.viewPager_home_recommand)
    ViewPager viewPagerHomeRecommand;
    @InjectView(R.id.tv_viewPager)
    TextView tvViewPager;
    @InjectView(R.id.viewPager_dot)
    LinearLayout viewPagerDot;

    private View view;
    private PtrClassicFrameLayout ptrClassicFrameLayout;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private Fragment_recommend_contract.Presenter mPresenter;
    private Fragment_recommend_contract.Model mModel;
    private List<RecommandBeans.CardBean> list;
    private List<RecommandBeans.CardBean.DataBean> pagerList, dataList, hotList, varityList, filmList, mvList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_recommend, null);
        ButterKnife.inject(this, view);
        initData();

        initPtr();
        initHttp();

        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        pagerList = new ArrayList<>();
        dataList = new ArrayList<>();
        hotList = new ArrayList<>();
        filmList = new ArrayList<>();
        mvList = new ArrayList<>();
        varityList = new ArrayList<>();

    }

    private void initRecycle_hot() {
        /*viewPager 的适配*/
        RecommandHotAdapter adapter = new RecommandHotAdapter(hotList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        manager.setOrientation(VERTICAL);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_recommand_hot);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        /*热门综艺的适配*/

        RecommandHotAdapter varityAdapter = new RecommandHotAdapter(varityList);
        GridLayoutManager varityManager = new GridLayoutManager(getActivity(), 3, VERTICAL, false);
        recyclerViewRecommandVarity.setLayoutManager(varityManager);
        recyclerViewRecommandVarity.setAdapter(varityAdapter);
        /*热门电影的适配*/

        RecommandHotAdapter filmAdapter = new RecommandHotAdapter(filmList);
        Log.i(TAG, "initRecycle_hot: film");
        GridLayoutManager filmManager = new GridLayoutManager(getActivity(), 3, VERTICAL, false);
        recyclerViewRecommandFilm.setLayoutManager(filmManager);
        recyclerViewRecommandFilm.setAdapter(filmAdapter);
        /*MV的适配*/
        ViewPagerForMV mvAdapter = new ViewPagerForMV(mvList, getActivity());
        Log.i(TAG, "initRecycle_hot: mv");
        viewpagerRecommandMv.setAdapter(mvAdapter);
    }

    private void initViewPager() {
//        layout= (LinearLayout) view.findViewById(R.id.viewPager_dot);
//        icons=new ImageView[list.get(0).getData().size()];
        Log.i(TAG, "initViewPager: " + list.get(0).getData().size());
//        if(list!=null){
//            for (int i=0;i<list.get(0).getData().size();i++){
//                icons[i].setImageResource(R.drawable.icon02);
//                layout.addView(icons[i]);
//            }
//        }
//        textView= (TextView) view.findViewById(R.id.tv_viewPager);
//        text=new String[list.get(0).getData().size()];
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_home_recommand);

        RecommandViewPagerAdapter adapter = new RecommandViewPagerAdapter(pagerList, getActivity());
        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                for (int i=0;i<list.get(0).getData().size();i++){
//                    icons[i].setImageResource(R.drawable.icon02);
//                }
//                icons[position].setImageResource(R.drawable.icon01);
//                textView.setText(list.get(0).getData().get(position).getTitle());
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    private void initHttp() {
        Log.i(TAG, "initHttp: ");
        mModel = new Fragment_recommend_model();
        mPresenter = new Fragment_recommend_presenter(this, mModel);
        mPresenter.initHttp();
    }


    private void initPtr() {
        ptrClassicFrameLayout = (PtrClassicFrameLayout) view.findViewById(R.id.ptrclassicframelayout);
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrClassicFrameLayout.refreshComplete();
                Toast.makeText(getActivity(), "aaaaaaaaaa", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSucess(RecommandBeans recommandBeans) {

        list.addAll(recommandBeans.getCard());
        Log.i(TAG, "onSucess: "+list.size());
        pagerList = list.get(0).getData();
        dataList = list.get(1).getData();
        hotList = list.get(2).getData();
        varityList = list.get(3).getData();
        filmList = list.get(4).getData();
        mvList = list.get(5).getData();
         initViewPager();
//        ViewPagerUtils.getPager(viewPagerDot,getActivity(),pagerList,viewPager,tvViewPager);
        initRecycle_hot();
    }

    @Override
    public void onFail(String failmsg) {
        Log.d("---------", "onFail: " + failmsg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}

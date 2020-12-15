package first.test.qimo.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import first.test.qimo.R;
import first.test.qimo.bean.BannerBean;
import first.test.qimo.fragment.ClasFragment;
import first.test.qimo.fragment.SchoolFragment;
import first.test.qimo.presenter.ImpBannerModel;

public class HomeActivity extends AppCompatActivity implements BannerView {


    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private ArrayList<BannerBean.BannerlistBean> list;
    private BannerAdapter bannerAdapter;
    private RecyclerView mRecycler;
    private ArrayList<Fragment> fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
        ImpBannerModel impBannerModel = new ImpBannerModel(this);
        impBannerModel.getBanner();
    }

    private void initView() {

        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        list = new ArrayList<>();
        bannerAdapter = new BannerAdapter(this, list);
        mRecycler.setAdapter(bannerAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        fragment = new ArrayList<>();
        fragment.add(new SchoolFragment());
        fragment.add(new ClasFragment());
        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }
        });
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.getTabAt(0).setText("学校新闻");
        mTablayout.getTabAt(1).setText("班级成绩查询");

    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        List<BannerBean.BannerlistBean> bannerlist = bannerBean.getBannerlist();
        list.addAll(bannerlist);
        bannerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e(TAG, "onFail: 错误信息"+error);
    }

    private static final String TAG = "HomeActivity";
}

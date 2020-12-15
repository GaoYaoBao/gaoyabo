package first.test.qimo.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import first.test.qimo.R;
import first.test.qimo.bean.SchoolBean;
import first.test.qimo.presenter.ImpSchoolPresenter;
import first.test.qimo.view.SchooView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment implements SchooView {


    private RecyclerView mRecycler;
    private ArrayList<SchoolBean.NewsBean> list;
    private ScholAdapter scholAdapter;

    public SchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_school, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ImpSchoolPresenter impSchoolPresenter = new ImpSchoolPresenter(this);
        impSchoolPresenter.getSchool();
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        list = new ArrayList<>();
        scholAdapter = new ScholAdapter(getActivity(), list);
        mRecycler.setAdapter(scholAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onSuccess(SchoolBean schoolBean) {
        List<SchoolBean.NewsBean> news = schoolBean.getNews();
        list.addAll(news);
        scholAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e(TAG, "onFail: 错误信息"+error );
    }

    private static final String TAG = "SchoolFragment";
}

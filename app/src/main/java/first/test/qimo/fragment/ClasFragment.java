package first.test.qimo.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import first.test.qimo.R;
import first.test.qimo.bean.ClasBean;
import first.test.qimo.presenter.ImpClasPresenter;
import first.test.qimo.view.ClasView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClasFragment extends Fragment implements ClasView {


    private RecyclerView mRecycler;
    private ArrayList<ClasBean.StudenlistBean> list;
    private ClasAdapter clasAdapter;
    private ImpClasPresenter impClasPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_clas, container, false);
        // Inflate the layout for this fragment
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        impClasPresenter = new ImpClasPresenter(this);
        impClasPresenter.getClas();
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        list = new ArrayList<>();
        clasAdapter = new ClasAdapter(getActivity(), list);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(clasAdapter);
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        clasAdapter.setMyClick(new ClasAdapter.MyClick() {
            @Override
            public void LongClick(int pos) {
                list.remove(pos);
                clasAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSuccess(ClasBean clasBean) {
        List<ClasBean.StudenlistBean> studenlist = clasBean.getStudenlist();
        list.addAll(studenlist);
        clasAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e(TAG, "onFail: 错误信息"+error);
    }

    private static final String TAG = "ClasFragment";
}

package first.test.qimo.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import first.test.qimo.R;
import first.test.qimo.bean.ClasBean;

class ClasAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ClasBean.StudenlistBean> list;

    public ClasAdapter(Context context, ArrayList<ClasBean.StudenlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.title_item, parent, false);
        return new TitleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ClasBean.StudenlistBean studenlistBean = list.get(position);
        TitleHolder titleHolder= (TitleHolder) holder;
        titleHolder.mName.setText("姓名"+studenlistBean.getName());
        titleHolder.mSkill.setText("机试成绩"+studenlistBean.getSkill()+"分");
        titleHolder.mThory.setText("理论成绩"+studenlistBean.getTheory()+"分");
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                myClick.LongClick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class TitleHolder extends RecyclerView.ViewHolder {
        View view;
        TextView mName;
        TextView mSkill;
        TextView mThory;

        TitleHolder(View view) {
            super(view);
            this.view = view;
            this.mName = (TextView) view.findViewById(R.id.name);
            this.mSkill = (TextView) view.findViewById(R.id.skill);
            this.mThory = (TextView) view.findViewById(R.id.thory);
        }
    }
    public interface MyClick{
        void LongClick(int pos);
    }
    MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }
}

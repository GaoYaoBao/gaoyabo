package first.test.qimo.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import first.test.qimo.R;
import first.test.qimo.bean.SchoolBean;
import retrofit2.http.POST;

class ScholAdapter extends RecyclerView.Adapter {
    private ArrayList<SchoolBean.NewsBean> list;
    Context context;

    public ScholAdapter(Context context, ArrayList<SchoolBean.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_item, parent, false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextHolder textHolder= (TextHolder) holder;
        SchoolBean.NewsBean newsBean = list.get(position);
        textHolder.mTitle.setText(newsBean.getTile());
        textHolder.mDesc.setText(newsBean.getContent());
        Glide.with(context).load(newsBean.getImageUrl()).into(textHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class TextHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView mImg;
        TextView mTitle;
        TextView mDesc;

        TextHolder(View view) {
            super(view);
            this.view = view;
            this.mImg = (ImageView) view.findViewById(R.id.img);
            this.mTitle = (TextView) view.findViewById(R.id.title);
            this.mDesc = (TextView) view.findViewById(R.id.desc);
        }
    }
}

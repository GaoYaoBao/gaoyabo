package first.test.qimo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import first.test.qimo.R;
import first.test.qimo.bean.BannerBean;

class BannerAdapter extends RecyclerView.Adapter {
    private ArrayList<BannerBean.BannerlistBean> list;
    Context context;

    public BannerAdapter(Context context, ArrayList<BannerBean.BannerlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else{
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
            return new BannerHolder(view);
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
            return new BannerHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case 0:
                final BannerHolder bannerHolder= (BannerHolder) holder;
            bannerHolder.mBanner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.BannerlistBean bannerlistBean1= (BannerBean.BannerlistBean) path;
                    Glide.with(context).load(bannerlistBean1.getHtmlurl()).into(imageView);
                }
            }).start();
            break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class BannerHolder extends RecyclerView.ViewHolder {
        View view;
        Banner mBanner;

        BannerHolder(View view) {
            super(view);
            this.view = view;
            this.mBanner = (Banner) view.findViewById(R.id.banner);
        }
    }
}

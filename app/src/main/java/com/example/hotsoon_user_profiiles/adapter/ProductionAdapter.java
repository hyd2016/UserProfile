package com.example.hotsoon_user_profiiles.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotsoon_user_profiiles.Interface.OnItemClickListener;
import com.example.hotsoon_user_profiiles.Json.Production;
import com.example.hotsoon_user_profiiles.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ProductionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Production> mProductionList;
    private static final int TYPE_BOTTOM_FRESH = 1;
    private static final int TYPE_NORMAL_ITEM = 2;


    //监听接口变量
    private OnItemClickListener mOnItemClickListener;

    public ProductionAdapter(List<Production> mProductionList) {
        this.mProductionList = mProductionList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == TYPE_NORMAL_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.production_item,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, (int) view.getTag());//注意这里使用getTag方法获取position
                    }
                }
            });
            return viewHolder;
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_fresh_item,parent,false);
            return new BottomRefreshViewHolder(view);
        }



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            holder.itemView.setTag(position);
            Production production = mProductionList.get(position);
            ((ViewHolder)holder).productionImage.setImageURI(production.getProductionData().getUserVideo().getCoverMediumUrl().getUrlList().get(0));
            ((ViewHolder)holder).likeNum.setText(production.getProductionData().getProductionStats().getDiggCount());
        }

    }


    //暴露给外部监听
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        if  (mProductionList != null){
            return mProductionList.size() + 1;
        }

        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position<mProductionList.size()){
            return TYPE_NORMAL_ITEM;
        }else {
            return TYPE_BOTTOM_FRESH;
        }
    }

    public boolean isBottomView(int position) {
        return position >= mProductionList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView productionImage;
        TextView likeNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productionImage = itemView.findViewById(R.id.user_production_image);
            likeNum = itemView.findViewById(R.id.like_num);
        }
    }

    // 定义底部刷新View对应的ViewHolder
    static class BottomRefreshViewHolder extends RecyclerView.ViewHolder {
        public BottomRefreshViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

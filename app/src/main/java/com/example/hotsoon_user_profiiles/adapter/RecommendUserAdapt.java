package com.example.hotsoon_user_profiiles.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotsoon_user_profiiles.Json.RecommendUser;
import com.example.hotsoon_user_profiiles.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecommendUserAdapt extends RecyclerView.Adapter<RecommendUserAdapt.ViewHolder> {
    private List<RecommendUser> mrecommendUserList;

    public RecommendUserAdapt(List<RecommendUser> mrecommendUserList) {
        this.mrecommendUserList = mrecommendUserList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecommendUser recommendUser = mrecommendUserList.get(position);
        holder.recommend_nick.setText(recommendUser.getUser().getNickName());
        holder.recommend_reason.setText(recommendUser.getRecommend_reason());
        holder.recommend_item_photo.setImageURI(recommendUser.getUser().getAvatarMedium().urls.get(0));
    }

    @Override
    public int getItemCount() {
        if(mrecommendUserList != null){
            return mrecommendUserList.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView recommend_item_photo;
        TextView recommend_nick;
        TextView recommend_reason;
        TextView attention_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recommend_item_photo = itemView.findViewById(R.id.recommend_item_photo);
            recommend_nick = itemView.findViewById(R.id.recommend_nick);
            recommend_reason = itemView.findViewById(R.id.recommend_reason);
            attention_item = itemView.findViewById(R.id.attention_item);
        }
    }
}

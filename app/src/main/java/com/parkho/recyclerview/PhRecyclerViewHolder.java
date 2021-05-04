package com.parkho.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parkho.recyclerview.PhRecyclerViewAdapter.OnItemClickEventListener;

public class PhRecyclerViewHolder extends RecyclerView.ViewHolder {

    public static int VIEW_TYPE = R.layout.content_recycler_item;

    TextView tvName;
    ImageView ivIcon;

    public PhRecyclerViewHolder(View a_itemView, final OnItemClickEventListener a_itemClickListener) {
        super(a_itemView);

        tvName = a_itemView.findViewById(R.id.tv_name);
        ivIcon = a_itemView.findViewById(R.id.iv_icon);

        a_itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a_view) {
                final int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    a_itemClickListener.onItemClick(a_view, position);
                }
            }
        });
    }
}
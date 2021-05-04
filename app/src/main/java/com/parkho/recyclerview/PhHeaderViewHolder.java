package com.parkho.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.parkho.recyclerview.PhRecyclerViewAdapter.OnItemClickEventListener;

public class PhHeaderViewHolder extends RecyclerView.ViewHolder {

    public static int VIEW_TYPE = R.layout.content_recycler_header;

    public PhHeaderViewHolder(@NonNull View a_itemView, final OnItemClickEventListener a_itemClickListener) {
        super(a_itemView);

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
package com.parkho.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PhRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickEventListener {
        void onItemClick(View a_view, int a_position);
    }

    private List<PhRecyclerItem> mItemList;

    private OnItemClickEventListener mItemClickListener;

    public PhRecyclerViewAdapter(List<PhRecyclerItem> a_list) {
        mItemList = a_list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(a_viewType, a_viewGroup, false);

        final RecyclerView.ViewHolder viewHolder;
        if (a_viewType == PhHeaderViewHolder.VIEW_TYPE) {
            viewHolder = new PhHeaderViewHolder(view, mItemClickListener);
        } else if (a_viewType == PhFooterViewHolder.VIEW_TYPE) {
            viewHolder = new PhFooterViewHolder(view, mItemClickListener);
        } else {
            viewHolder = new PhRecyclerViewHolder(view, mItemClickListener);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder a_holder, int a_position) {
        if (a_holder instanceof PhHeaderViewHolder) {
            PhHeaderViewHolder headerViewHolder = (PhHeaderViewHolder) a_holder;
        } else if (a_holder instanceof PhFooterViewHolder) {
            PhFooterViewHolder footerViewHolder = (PhFooterViewHolder) a_holder;
        } else {
            // 기본적으로 header 를 빼고 item 을 구한다.
            final PhRecyclerItem item = mItemList.get(a_position - 1);

            PhRecyclerViewHolder viewHolder = (PhRecyclerViewHolder) a_holder;

            viewHolder.ivIcon.setImageResource(item.getImageResId());
            viewHolder.tvName.setText(item.getName());
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size() + 2;
    }

    @Override
    public int getItemViewType(int a_position) {
        if (a_position == 0) {
            return PhHeaderViewHolder.VIEW_TYPE;
        } else if (a_position == mItemList.size() + 1) {
            return PhFooterViewHolder.VIEW_TYPE;
        } else {
            return PhRecyclerViewHolder.VIEW_TYPE;
        }
    }

    public void setOnItemClickListener(OnItemClickEventListener a_listener) {
        mItemClickListener = a_listener;
    }
}
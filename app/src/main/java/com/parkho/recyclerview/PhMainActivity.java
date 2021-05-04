package com.parkho.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.parkho.recyclerview.PhRecyclerViewAdapter.OnItemClickEventListener;

import java.util.ArrayList;
import java.util.List;

public class PhMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List 설정
        bindList();
    }

    /**
     * List 설정
     */
    private void bindList() {
        // List item 생성
        final List<PhRecyclerItem> itemList = new ArrayList<>();
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f600, "emoji_u1f600"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f601, "emoji_u1f601"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f602, "emoji_u1f602"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f603, "emoji_u1f603"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f604, "emoji_u1f604"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f605, "emoji_u1f605"));

        // Recycler view
        RecyclerView rcyclerView = findViewById(R.id.recycler_view);

        // Adapter 설정
        PhRecyclerViewAdapter adapter = new PhRecyclerViewAdapter(itemList);
        rcyclerView.setAdapter(adapter);

        // Recycler view item click event 처리
        adapter.setOnItemClickListener(new OnItemClickEventListener() {
            @Override
            public void onItemClick(View a_view, int a_position) {
                if (a_position == 0) {
                    Toast.makeText(PhMainActivity.this, "The header is selected", Toast.LENGTH_SHORT).show();
                } else if (a_position == itemList.size() + 1){
                    Toast.makeText(PhMainActivity.this, "The footer is selected", Toast.LENGTH_SHORT).show();
                } else {
                    final PhRecyclerItem item = itemList.get(a_position - 1);
                    Toast.makeText(PhMainActivity.this, item.getName() + " Click event", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcyclerView.setLayoutManager(layoutManager);
    }
}
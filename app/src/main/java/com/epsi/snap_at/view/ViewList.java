package com.epsi.snap_at.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epsi.snap_at.Card;
import com.epsi.snap_at.Notifier;
import com.epsi.snap_at.R;
import com.epsi.snap_at.SnapAtApplication;
import com.epsi.snap_at.adapter.CardViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewList extends AppCompatActivity {

    private RecyclerView crv;
    private List<Card> cards;
    private CardViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);

        this.cards = new ArrayList<>();
        this.adapter = new CardViewAdapter(cards);


        cards.addAll(((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                (c) -> c.getStatus() == getIntent().getSerializableExtra("status")
        ));
        cards.sort((a, b) -> b.getDate().compareTo(a.getDate()));

        crv = (RecyclerView) findViewById(R.id.recyclerView);
        crv.setLayoutManager(new LinearLayoutManager(this));
        crv.setAdapter(adapter);

        System.out.println(adapter.getItemCount());
        Notifier.todos.add(() -> {
            cards.clear();
            cards.addAll(((SnapAtApplication) getApplication()).getHandler().getBaseWithCondition(
                    (c) -> c.getStatus() == getIntent().getSerializableExtra("status")
            ));
            cards.sort((a, b) -> b.getDate().compareTo(a.getDate()));
            runOnUiThread(adapter::notifyDataSetChanged);
        });
    }


}

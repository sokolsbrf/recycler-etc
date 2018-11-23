package com.example.sokol.colors;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerActivity extends Activity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(new RecyclersColorsAdapter());

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}

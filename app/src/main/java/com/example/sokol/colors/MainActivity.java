package com.example.sokol.colors;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView colorsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorsListView = findViewById(R.id.list);
        colorsListView.setAdapter(new ColorsAdapter());

//        colorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                view.setBackgroundColor(Color.CYAN);
//            }
//        });
    }
}

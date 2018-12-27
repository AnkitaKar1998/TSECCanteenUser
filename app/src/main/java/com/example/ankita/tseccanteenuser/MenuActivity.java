package com.example.ankita.tseccanteenuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuViewAdapter adapter;
    List<MenuProducts> menuprods;
    //MenuViewAdapter.clickListener clicky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuprods = new ArrayList<>();
        recyclerView = findViewById(R.id.menu_items_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menuprods.add(new MenuProducts(R.drawable.thali,"Thali","Delicious", "50", "0"));
        menuprods.add(new MenuProducts(R.drawable.pavbhaji,"Pav Bhaji","Delicious", "70", "0"));
        menuprods.add(new MenuProducts(R.drawable.vadapav,"Vada Pav","Delicious", "20", "0"));

//        clicky = new MenuViewAdapter.clickListener() {
//            private String x;
//            private Integer y;
//            @Override
//            public void plusItem(int position, TextView v1) {
//                x=v1.getText().toString();
//                y=Integer.parseInt(x);
//                y++;
//                x=Integer.toString(y);
//                v1.setText(x);
//            }
//
//            @Override
//            public void minusItem(int position, TextView v2) {
//                x=v2.getText().toString();
//                y=Integer.parseInt(x);
//                y--;
//                x=Integer.toString(y);
//                v2.setText(x);
//            }
//        };

        adapter = new MenuViewAdapter(this,menuprods);
        recyclerView.setAdapter(adapter);
    }
}

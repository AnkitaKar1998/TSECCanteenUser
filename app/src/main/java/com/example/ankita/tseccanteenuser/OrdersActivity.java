package com.example.ankita.tseccanteenuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        products = new ArrayList<>();
        recyclerView = findViewById(R.id.orders_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        products.add(
                new Product(R.drawable.pavbhaji,"Pav Bhaji","Delicious","Price","Status","25 Rs.","Delivered"));
        products.add(
                new Product(R.drawable.vadapav,"VadaPav","Delicious","Price","Status","30 Rs.","Delivered"));
        products.add(
                new Product(R.drawable.thali,"Thali","Delicious","Price","Status","105 Rs.","Delivered"));

        recyclerViewAdapter = new RecyclerViewAdapter(this,products);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


}

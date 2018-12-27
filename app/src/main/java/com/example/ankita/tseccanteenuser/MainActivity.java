package com.example.ankita.tseccanteenuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CardView orders;
    CardView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orders = (CardView)findViewById(R.id.ordercardview);
        orders.setOnClickListener(this);
        menu = (CardView)findViewById(R.id.menucardview);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ordercardview){
            Intent i = new Intent(MainActivity.this,OrdersActivity.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(MainActivity.this,MenuActivity.class);
            startActivity(i);
        }
    }
}

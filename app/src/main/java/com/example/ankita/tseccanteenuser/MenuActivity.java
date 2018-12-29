package com.example.ankita.tseccanteenuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuViewAdapter adapter;
    List<MenuProducts> menuprods;
    List<SendProducts> products;
    MenuViewAdapter.clickListener clicky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuprods = new ArrayList<>();
        products = new ArrayList<>();
        recyclerView = findViewById(R.id.menu_items_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menuprods.add(new MenuProducts(R.drawable.thali,"Thali","Delicious", "50", "0"));
        menuprods.add(new MenuProducts(R.drawable.pavbhaji,"Pav Bhaji","Delicious", "70", "0"));
        menuprods.add(new MenuProducts(R.drawable.vadapav,"Vada Pav","Delicious", "20", "0"));

        clicky=new MenuViewAdapter.clickListener(){
            @Override
            public void sendData(SendProducts p) {
                int i=0,tQ=0,tP=0;
                String tempN,tempQ,tempP;
                if(products.size()==0)
                {
                    products.add(p);
//                    i=-1;
                }
                else
                {
                    for (SendProducts x : products)
                    {
                        if(x.getN().equals(p.getN()))
                        {
                            x.setQ(p.getQ());
                            x.setP(p.getP());
                            i=1;
                        }

//                        while(i!=products.size())
//                        {
//                           i++;
//                           tempN=x.getN();
//                           if(tempN.equals(p.getN()))
//                           {
//                               tempQ=x.getQ();
//                               tQ=Integer.parseInt(tempQ);
//                               tempP=x.getP();
//                               tP=Integer.parseInt(tempP);
//                               tP=tP*tQ;
//                               x.setP(Integer.toString(tP));
//                               i=-1;
//                               break;
//                           }
//                        }
//                        if(i==-1)
//                        {
//                            break;
//                        }
//                        if(i!=-1)
//                        {
//                            products.add(p);
//                        }
                    }

                    if(i!=1)
                    {
                        products.add(p);
                    }
                }

                Button b = (Button)findViewById(R.id.pay);
                b.setOnClickListener(new View.OnClickListener() {
                    int i;
                    @Override
                    public void onClick(View v) {
                        for (SendProducts x : products){
                            i++;
                            Log.d("ShowData","Object "+i+":\n" + "Name: " + x.getN() + "\nQuantity:" +x.getQ()+"\nPrice:"+ x.getP() +"\n");
                        }
                    }
                });
            }
        };

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

        adapter = new MenuViewAdapter(this,menuprods,clicky);
        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public void sendData(SendProducts p) {
//        int i;
//        products.add(p);
//        Button b = (Button)findViewById(R.id.pay);
//        for (SendProducts x : products){
//                   Log.d("ShowData","Hello");
//               }

//
//    }
}

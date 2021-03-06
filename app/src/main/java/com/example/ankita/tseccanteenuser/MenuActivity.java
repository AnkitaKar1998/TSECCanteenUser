package com.example.ankita.tseccanteenuser;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuViewAdapter adapter;
    ArrayList<MenuProducts> menuprods;
    ArrayList<SendProducts> products;
    MenuViewAdapter.clickListener clicky;
    Firebase mRootRef;
    String currentUserName;
    String uid;
    DatabaseReference dbr;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference foodref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        menuprods = new ArrayList<>();
        products = new ArrayList<>();

//        menuprods.add(new MenuProducts(R.drawable.thali,"Thali","Delicious", "50", "0"));
//        menuprods.add(new MenuProducts(R.drawable.pavbhaji,"Pav Bhaji","Delicious", "70", "0"));
//        menuprods.add(new MenuProducts(R.drawable.vadapav,"Vada Pav","Delicious", "20", "0"));

        foodref = FirebaseDatabase.getInstance().getReference("FoodsAnkita");
        foodref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                menuprods = new ArrayList<>();
                MenuProducts menuProducts;
                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    menuProducts = ds.getValue(MenuProducts.class);
                    Log.d("ShowData","Name: " + menuProducts.getName());
                    menuprods.add(menuProducts);

                }
                recyclerView = findViewById(R.id.menu_items_recycler_view);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MenuActivity.this));
                adapter = new MenuViewAdapter(MenuActivity.this,menuprods,clicky);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        dbr = FirebaseDatabase.getInstance().getReference();
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentUserName = dataSnapshot.child("Users").child(uid).child("name").getValue(String.class);
                Log.d("ShowData", "Name: "+currentUserName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        clicky=new MenuViewAdapter.clickListener(){
            @Override
            public void sendData(SendProducts p) {
                int i=0,tQ=0,tP=0;
                String tempN,tempQ,tempP;
                if(products.size()==0)
                {
                    products.add(p);
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

                    }

                    if(i!=1)
                    {
                        products.add(p);
                    }
                }


            }
        };

        Button b = (Button)findViewById(R.id.pay);
        b.setOnClickListener(new View.OnClickListener() {
            int i;
            @Override
            public void onClick(View v) {

                int t_price=0;

                DatabaseReference root = FirebaseDatabase.getInstance().getReference("R_Orders");
                Random random = new Random();
                int r = random.nextInt(65);
                int rand = random.nextInt(125478963);
                int min = 1000;
                int max = 9999;
                int otp = random.nextInt((max-min)+1)+min;
                String rand1 = Integer.toString(rand);
                final String oid = "O"+Integer.toString(r);

                RetrieveOrdersModel retrieveOrdersModel = new RetrieveOrdersModel();
                retrieveOrdersModel.setName(currentUserName);
                retrieveOrdersModel.setC_id(uid);
                retrieveOrdersModel.setOrder_id(oid);
                retrieveOrdersModel.setStatus("Pending");
                retrieveOrdersModel.setOtp(Integer.toString(otp));
                ArrayList<RetrieveFoodsModel> retrieveFoodsModels = new ArrayList<>();

                for (SendProducts x : products){
                    String fid;
                    i++;
                    t_price = t_price + Integer.parseInt(x.getP());
                    fid="F"+Integer.toString(i);
                    RetrieveFoodsModel obj=new RetrieveFoodsModel();
                    obj.setName(x.getN());
                    obj.setPrice(x.getP());
                    obj.setQuantity(x.getQ());
                    retrieveFoodsModels.add(obj);
                }
                retrieveOrdersModel.setFoods(retrieveFoodsModels);
                retrieveOrdersModel.setPrice(Integer.toString(t_price));
                root.child(rand1).setValue(retrieveOrdersModel);

            }

        });



    }



}

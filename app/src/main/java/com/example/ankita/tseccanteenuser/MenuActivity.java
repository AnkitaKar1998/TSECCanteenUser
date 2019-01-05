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
    List<MenuProducts> menuprods;
    List<SendProducts> products;
    MenuViewAdapter.clickListener clicky;
    Firebase mRootRef;
    String currentUserName;
    String uid;
    DatabaseReference dbr;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


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

        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        dbr = FirebaseDatabase.getInstance().getReference();
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Log.d("ShowData", "ankita before");
                currentUserName = dataSnapshot.child("Users").child(uid).child("name").getValue(String.class);
                Log.d("ShowData", "Name: "+currentUserName);
//                Map<String,String> map = dataSnapshot.getValue(Map.class);
//                  currentUserName = map.get("name");
//                  Log.d("ShowData","Name: "+currentUserName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



       // mRootRef = new Firebase("https://tseccanteen-f57af.firebaseio.com/Test");
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
                final String rand = mDatabase.push().getKey();
                        //Integer.toString(random.nextInt(1245785));
                final String oid = "O"+Integer.toString(r);
                root.child(rand).child("C_id").setValue(uid);
                root.child(rand).child("Order_id").setValue(oid);
                Log.d("ShowData", "order: "+oid);

                for (SendProducts x : products){
                    String fid;
                    i++;
                    //Log.d("ShowData","Object "+i+":\n" + "Name: " + x.getN() + "\nQuantity:" +x.getQ()+"\nPrice:"+ x.getP() +"\n");
                    t_price = t_price + Integer.parseInt(x.getP());
                    fid="F"+Integer.toString(i);
                    RetrieveFoodsModel obj=new RetrieveFoodsModel();
                    obj.setName(x.getN());
                    obj.setPrice(x.getP());
                    obj.setQuantity(x.getQ());
                    Log.d("msg","in for");
//                    root.child(rand).child("Foods").child(fid).setValue(obj);
                    mDatabase.child("R_Orders").child(rand).child("Foods").child(mDatabase.push().getKey()).setValue(obj);
//                    root.child(rand).child("Foods").child(fid).child("Name").setValue(x.getN());
//                    root.child(rand).child("Foods").child(fid).child("Quantity").setValue(x.getQ());
//                    root.child(rand).child("Foods").child(fid).child("Price").setValue(x.getP());
                    //root.child(oid).child("Foods").child(x.getN()).child("Quantity").setValue(x.getQ());
                }
                root.child(rand).child("Price").setValue(Integer.toString(t_price));
                root.child(rand).child("Status").setValue("Pending");
                root.child(rand).child("Name").setValue(currentUserName);


//                        root.child("testy").child("Name").setValue("Abc");
//                        root.child("testy").child("test").setValue("Y");


            }

        });


        adapter = new MenuViewAdapter(this,menuprods,clicky);
        recyclerView.setAdapter(adapter);
    }



}

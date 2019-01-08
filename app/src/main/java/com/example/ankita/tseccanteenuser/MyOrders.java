package com.example.ankita.tseccanteenuser;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {
    RecyclerView recyclerView;
    MyOrdersRecyclerViewAdapter myOrdersRecyclerViewAdapter;
    ArrayList<RetrieveFoodsModel> foods=new ArrayList<>();
    ArrayList<RetrieveOrdersModel> retrieveOrdersModels,retrieveOrdersModels1;
    ArrayList<RetrieveFoodsModel> mfmc,mfmc1;
    String currentUserName,userId;
    DatabaseReference rootref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        userId = FirebaseAuth.getInstance().getUid();
        mfmc = new ArrayList<>();
        retrieveOrdersModels1 =  new ArrayList<>();
        Query query = FirebaseDatabase.getInstance().getReference().child("R_Orders").orderByChild("c_id").equalTo(userId);
        Log.d("ShowData","User Id : "+userId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                retrieveOrdersModels = new ArrayList<>();
                RetrieveOrdersModel retrieveOrdersModel = new RetrieveOrdersModel();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    retrieveOrdersModel= ds.getValue(RetrieveOrdersModel.class);
                    Log.d("ShowData","Foods" + retrieveOrdersModel.getFoods().size());
                    retrieveOrdersModels.add(retrieveOrdersModel);
                }

                recyclerView = findViewById(R.id.my_orders_recycler_view);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MyOrders.this));
                myOrdersRecyclerViewAdapter = new MyOrdersRecyclerViewAdapter(MyOrders.this,retrieveOrdersModels);
                recyclerView.setAdapter(myOrdersRecyclerViewAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}

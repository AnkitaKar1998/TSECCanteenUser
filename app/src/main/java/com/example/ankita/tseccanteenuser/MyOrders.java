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
    ArrayList<RetrieveOrdersModel> retrieveOrdersModels=new ArrayList<>();
    ArrayList<RetrieveFoodsModel> mfmc,mfmc1;
    String currentUserName,userId;
    DatabaseReference rootref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        userId = FirebaseAuth.getInstance().getUid();
        mfmc = new ArrayList<>();
        Query query = FirebaseDatabase.getInstance().getReference().child("R_Orders").orderByChild("C_id").equalTo(userId);
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                retrieveOrdersModels = new ArrayList<RetrieveOrdersModel>();
//                for(DataSnapshot ds : dataSnapshot.getChildren())
//                {
//                    Log.d("ShowData","Json"+ds.getValue());
////                    String oid = ds.child("Order_id").getValue(String.class);
////                    Log.d("ShowData", "Order_Id: "+oid);
//////
////                    String price = ds.child("Price").getValue(String.class);
////                    Log.d("ShowData", "price: "+price);
////
////                    String status = ds.child("Status").getValue(String.class);
////                    Log.d("ShowData", "status: "+status);
////
////                    String cid = ds.child("C_id").getValue(String.class);
////                    Log.d("ShowData", "C_id: "+cid);
////
////                    String c_name = ds.child("Name").getValue(String.class);
////                    Log.d("ShowData", "price: "+c_name);
////
////                    for (DataSnapshot d : ds.getChildren())
////                    {
////                        Log.d("ShowData","Keys"+ d.getKey());
////                    }
//                    RetrieveOrdersModel retrieveOrdersModel = ds.getValue(RetrieveOrdersModel.class);
//                    Log.d("ShowData","Foods" + retrieveOrdersModel.getFoods().size());
//                    retrieveOrdersModels.add(retrieveOrdersModel);
//                }
////                for (RetrieveOrdersModel x : retrieveOrdersModels)
////                {
////                    Log.d("ShowData","OrderId :" + x.getOrder_id());
////                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });



//        momc = new ArrayList<>();
//        mfmc = new ArrayList<>();
//        mfmc1 = new ArrayList<>();
//        recyclerView = findViewById(R.id.my_orders_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        mfmc.add(new MyFoodModelClass("Vadapav","2","30"));
//        mfmc.add(new MyFoodModelClass("Thali","3","300"));
//
//        mfmc1.add(new MyFoodModelClass("Vadapav","2","30"));
//        mfmc1.add(new MyFoodModelClass("Thali","3","300"));
//
//        momc.add(new MyOrdersModelClass("O11",2,"240","Pending",mfmc));
//        momc.add(new MyOrdersModelClass("O12",2,"240","Pending",mfmc1));

//        myOrdersRecyclerViewAdapter = new MyOrdersRecyclerViewAdapter(this,retrieveOrdersModels);
//        recyclerView.setAdapter(myOrdersRecyclerViewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("urmi", "onStart()");
        FirebaseDatabase.getInstance().getReference().child("OrdersAnkita").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("urmi", "onDataChange()");
//                int i=0;
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    Log.d("urmi", "ankita before");
                    MyOrdersModelClass myOrdersModelClass = data.getValue(MyOrdersModelClass.class);
                    Log.d("urmi", "ankita after");

                    Log.d("urmi", "START");
                    Log.d("urmi", "amount: "+myOrdersModelClass.getAmount());
                    Log.d("urmi", "order: "+myOrdersModelClass.getOrderNo());
                    Log.d("urmi", "sname: "+myOrdersModelClass.getStudentName());
                    Log.d("urmi", "sid: "+myOrdersModelClass.getStudentId());
                    for(int i=0; i<myOrdersModelClass.getFoods().size(); i++) {
                        Log.d("urmi", "START 111111");
                        Log.d("urmi", "name: " + myOrdersModelClass.getFoods().get(i).getName());
                        Log.d("urmi", "quantity: " + myOrdersModelClass.getFoods().get(i).getQuantity());
                        Log.d("urmi", "price: " + myOrdersModelClass.getFoods().get(i).getPrice());
                        Log.d("urmi", "END 11111111");
                    }
                    Log.d("urmi", "END");



//                    String Price = data.child("Price").getValue(String.class);
//                    String C_id = data.child("C_id").getValue(String.class);
//                    String Order_id = data.child("Order_id").getValue(String.class);
//                    String Name = data.child("Name").getValue(String.class);
//                    String Status = data.child("Status").getValue(String.class);
//
//                    Log.d("urmi", "START");
//                    Log.d("urmi", "Price: "+Price);
//                    Log.d("urmi", "C_id: "+C_id);
//                    Log.d("urmi", "Order_id: "+Order_id);
//                    Log.d("urmi", "Name: "+Name);
//                    Log.d("urmi", "Status: "+Status);


//                    int totalNodes = (int) data.child("Foods").getChildrenCount();
//                    for(int j=0; j<totalNodes; j++) {
//                        RetrieveFoodsModel retrieveFoodsModel = data.child("Foods").child("F"+(j+1)).getValue(RetrieveFoodsModel.class);
//
//                        Log.d("urmi", "START 111111");
//                        Log.d("urmi", "name: " + retrieveFoodsModel.getName());
//                        Log.d("urmi", "quantity: " + retrieveFoodsModel.getQuantity());
//                        Log.d("urmi", "price: " + retrieveFoodsModel.getPrice());
//                        Log.d("urmi", "END 11111111");
//
//                    }
//
//                    Log.d("urmi", "END");




//                    retrieveOrdersModels.add(data.getValue(RetrieveOrdersModel.class));
//                    foods.add(data.getValue(RetrieveOrdersModel.class).getFoods().get(i));
//                    Log.d("ShowD","foods size:"+foods.size());
//                    Log.d("ShowD","list Size :"+retrieveOrdersModels.size());
//                    Log.d("ShowData","data: "+retrieveOrdersModels.get(i).getFoods());
//                    i++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

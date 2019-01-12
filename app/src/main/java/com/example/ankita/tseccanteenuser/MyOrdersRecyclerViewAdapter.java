package com.example.ankita.tseccanteenuser;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyOrdersRecyclerViewAdapter extends RecyclerView.Adapter<MyOrdersRecyclerViewAdapter.MyOrdersViewHolder>{
    private Context c;
    private List<RetrieveOrdersModel> plist;
    LinearLayout o_list;

    public MyOrdersRecyclerViewAdapter(Context c, List<RetrieveOrdersModel> plist) {
        this.c = c;
        this.plist = plist;
    }

    @NonNull
    @Override
    public MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater l = LayoutInflater.from(viewGroup.getContext());
        View v = l.inflate(R.layout.myorderscustomized,viewGroup,false);
        return new MyOrdersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersViewHolder myOrdersViewHolder, int i) {
        String rupee = c.getResources().getString(R.string.Rs);
        RetrieveOrdersModel momc = plist.get(i);
        myOrdersViewHolder.order_no.setText("Order No: " + momc.getOrder_id());
        addViews(myOrdersViewHolder,momc);
        if(momc.getStatus().equals("Pending"))
        {
            myOrdersViewHolder.otp.setText(momc.getOtp());
        }
        else
        {
            myOrdersViewHolder.tick.setVisibility(View.VISIBLE);
            myOrdersViewHolder.otplinearlayout.setVisibility(View.GONE);
            myOrdersViewHolder.ld.setBackgroundColor(Color.parseColor("#98FB98"));
        }
        myOrdersViewHolder.status.setText(momc.getStatus());
        myOrdersViewHolder.tot_price.setText(rupee+" "+ momc.getPrice());

    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class MyOrdersViewHolder extends RecyclerView.ViewHolder{
        TextView order_no,tot_price,status,otp;
        LinearLayout ld,otplinearlayout,ld1;
        ImageView tick;
        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            ld = itemView.findViewById(R.id.items_linear_layout_L1);
            order_no=itemView.findViewById(R.id.Order_Number);
            tot_price=itemView.findViewById(R.id.total_price);
            status = itemView.findViewById(R.id.now_status);
            tick = itemView.findViewById(R.id.tick);
            otp = itemView.findViewById(R.id.otp);
            ld = itemView.findViewById(R.id.holder_linear_layout);
            ld1 = itemView.findViewById(R.id.items_linear_layout_L1);
            otplinearlayout = itemView.findViewById(R.id.otp_linear_layout);
        }
    }

    public void addViews(MyOrdersViewHolder vh, RetrieveOrdersModel obj)
    {
        List<RetrieveFoodsModel> mfmc = obj.getFoods();
        String rupee = c.getResources().getString(R.string.Rs);

        for (RetrieveFoodsModel m : mfmc)
        {
            o_list = new LinearLayout(c);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            o_list.setLayoutParams(params);
            o_list.setOrientation(LinearLayout.HORIZONTAL);
            TextView tv1 = new TextView(c);
            TextView tv2 = new TextView(c);
            TextView tv3 = new TextView(c);
            tv1.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1f));
            tv2.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1f));
            tv3.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1f));
            tv1.setText(m.getName());
            tv2.setText(m.getQuantity());
            tv3.setText(rupee + " " + m.getPrice());
            o_list.addView(tv1);
            o_list.addView(tv2);
            o_list.addView(tv3);
            vh.ld1.addView(o_list);
        }

    }
}

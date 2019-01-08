package com.example.ankita.tseccanteenuser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        RetrieveOrdersModel momc = plist.get(i);
        myOrdersViewHolder.order_no.setText("Order No: " + momc.getOrder_id());
        addViews(myOrdersViewHolder,momc);
        myOrdersViewHolder.status.setText(momc.getStatus());
        myOrdersViewHolder.tot_price.setText(momc.getPrice());

    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class MyOrdersViewHolder extends RecyclerView.ViewHolder{
        TextView order_no,tot_price,status;
        LinearLayout ld;
        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            ld = itemView.findViewById(R.id.items_linear_layout_L1);
            order_no=itemView.findViewById(R.id.Order_Number);
            tot_price=itemView.findViewById(R.id.total_price);
            status = itemView.findViewById(R.id.now_status);

        }
    }

    public void addViews(MyOrdersViewHolder vh, RetrieveOrdersModel obj)
    {
        List<RetrieveFoodsModel> mfmc = obj.getFoods();

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
            tv3.setText(m.getPrice());
            o_list.addView(tv1);
            o_list.addView(tv2);
            o_list.addView(tv3);
            vh.ld.addView(o_list);
        }

    }
}

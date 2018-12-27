package com.example.ankita.tseccanteenuser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Product> products;


    public RecyclerViewAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_recycler_customized, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = products.get(i);
        viewHolder.title.setText(product.getP_name());
        viewHolder.description.setText(product.getP_desc());
        viewHolder.price.setText(product.getPrice());
        viewHolder.status.setText(product.getStat());
        viewHolder.real_price.setText(product.getReal_price());
        viewHolder.real_status.setText(product.getReal_status());
        viewHolder.order_image.setImageDrawable(context.getResources().getDrawable(product.getImg()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView order_image;
        TextView title,description, price,status,real_price,real_status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_image = itemView.findViewById(R.id.ordered_product_image);
            title = itemView.findViewById(R.id.ordered_product_name);
            description = itemView.findViewById(R.id.ordered_desription);
            price = itemView.findViewById(R.id.order_price);
            status = itemView.findViewById(R.id.order_status);
            real_price = itemView.findViewById(R.id.order_ka_price);
            real_status = itemView.findViewById(R.id.order_ka_status);
        }
    }
}

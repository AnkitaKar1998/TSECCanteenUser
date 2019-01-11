package com.example.ankita.tseccanteenuser;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MenuViewAdapter extends RecyclerView.Adapter<MenuViewAdapter.MenuViewHolder> {
    private Context ctx;
    private ArrayList<MenuProducts> menulist;
    public clickListener click;
    private ArrayList<SendProducts> products;

    public MenuViewAdapter(Context ctx, ArrayList<MenuProducts> menulist ,clickListener click) {
        this.ctx = ctx;
        this.menulist = menulist;
        this.click=click;
    }

    interface clickListener{
        void sendData(SendProducts p);
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.menu_recycler_customized, null);
        MenuViewHolder holder = new MenuViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MenuViewHolder menuViewHolder, int i) {



        final MenuProducts mp = menulist.get(i);
        menuViewHolder.title.setText(mp.getName());
        menuViewHolder.description.setText(mp.getDescription());
        menuViewHolder.price.setText(mp.getPrice());
        menuViewHolder.quantity.setText("0");
//        StorageReference storageReference = FirebaseStorage.getInstance().getReference(mp.getImage());
        Glide.with(ctx)
                .load(mp.getImage())
                .into(menuViewHolder.menu_image);
//        menuViewHolder.menu_image.setImageDrawable(ctx.getResources().getDrawable(mp.getImg()));

        menuViewHolder.plus_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x;
                int y,z;
                String name,price;
                x=menuViewHolder.quantity.getText().toString();
                y=Integer.parseInt(x);
                y++;
                x=Integer.toString(y);
                menuViewHolder.quantity.setText(x);

                name = menuViewHolder.title.getText().toString();
                price = menuViewHolder.price.getText().toString();

                z = Integer.parseInt(price);
                z=z*y;

                price = Integer.toString(z);

                SendProducts s = new SendProducts(name,x,price);
                click.sendData(s);
//                Log.d("ShowData","object s before: "+s.getQ());
//                click.sendData(new SendProducts(name,x,price));
//                Log.d("ShowData","object s after: "+s.getQ());
            }
        });

        menuViewHolder.minus_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=null;
                Integer y=0;
                String name=null,price=null;
                x=menuViewHolder.quantity.getText().toString();
                y=Integer.parseInt(x);
                y--;
                x=Integer.toString(y);
                menuViewHolder.quantity.setText(x);

                name = menuViewHolder.title.getText().toString();
                price = menuViewHolder.price.getText().toString();

                SendProducts s = new SendProducts(name,x,price);

                click.sendData(s);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menulist.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        ImageView menu_image;
        TextView title,description, price,quantity;
        Button plus_butt,minus_butt;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            menu_image = itemView.findViewById(R.id.menu_product_image);
            title = itemView.findViewById(R.id.menu_product_name);
            description = itemView.findViewById(R.id.menu_product_desription);
            price = itemView.findViewById(R.id.menu_ka_price);
            quantity =(TextView) itemView.findViewById(R.id.menu_ka_quantity);
            plus_butt = itemView.findViewById(R.id.plus_button);
            minus_butt = itemView.findViewById(R.id.minus_button);



//            plus_butt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    click.plusItem(getAdapterPosition(),quantity);
//                }
//            });
//
//            minus_butt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    click.minusItem(getAdapterPosition(),quantity);
//                }
//            });
        }
    }
}

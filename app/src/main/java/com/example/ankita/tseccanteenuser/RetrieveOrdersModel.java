package com.example.ankita.tseccanteenuser;

import java.util.ArrayList;

public class RetrieveOrdersModel {
    private String c_id, name, order_id, price, status;
    private ArrayList<RetrieveFoodsModel> foods;

    public String getC_id() {
        return c_id;
    }

    public String getName() {
        return name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<RetrieveFoodsModel> getFoods() {
        return foods;
    }



    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFoods(ArrayList<RetrieveFoodsModel> foods) {
        this.foods = foods;
    }
}

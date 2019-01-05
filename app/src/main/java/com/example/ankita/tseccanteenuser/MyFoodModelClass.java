package com.example.ankita.tseccanteenuser;

import java.util.List;

public class MyFoodModelClass {
    String food_name,food_quant,food_price;
    public MyFoodModelClass(String food_name, String food_quant, String food_price) {
        this.food_name = food_name;
        this.food_quant = food_quant;
        this.food_price = food_price;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_quant() {
        return food_quant;
    }

    public void setFood_quant(String food_quant) {
        this.food_quant = food_quant;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }
}

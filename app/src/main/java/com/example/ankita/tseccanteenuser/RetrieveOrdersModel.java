package com.example.ankita.tseccanteenuser;

import java.util.ArrayList;
import java.util.List;

public class RetrieveOrdersModel {
    private String C_id, Name, Order_id, Price, Status;
    private ArrayList<RetrieveFoodsModel> Foods;

    public String getC_id() {
        return C_id;
    }

    public String getName() {
        return Name;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public String getPrice() {
        return Price;
    }

    public String getStatus() {
        return Status;
    }

    public ArrayList<RetrieveFoodsModel> getFoods() {
        return Foods;
    }
}

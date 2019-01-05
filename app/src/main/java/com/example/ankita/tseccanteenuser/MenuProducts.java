package com.example.ankita.tseccanteenuser;

public class MenuProducts {
    private int image;
    private String p_name,prod_desc,price,quantity;

    public MenuProducts(int image, String p_name, String prod_desc, String price, String quantity) {
        this.image = image;
        this.p_name = p_name;
        this.prod_desc = prod_desc;
        this.price = price;
        this.quantity=quantity;
    }

    public int getImg() {
        return image;
    }

    public String getP_name() {
        return p_name;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }
}

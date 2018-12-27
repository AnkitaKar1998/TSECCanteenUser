package com.example.ankita.tseccanteenuser;

public class Product {
    private int image;
    private String p_name,p_desc,price,status,real_price,real_status;


    public Product(int image, String p_name, String p_desc, String price, String status, String real_price, String real_status) {
        this.image = image;
        this.p_name = p_name;
        this.p_desc = p_desc;
        this.price = price;
        this.status = status;
        this.real_price=real_price;
        this.real_status=real_status;
    }

    public String getReal_price() {
        return real_price;
    }

    public String getReal_status() {
        return real_status;
    }

    public int getImg() {
        return image;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_desc() {
        return p_desc;
    }

    public String getPrice() {
        return price;
    }

    public String getStat() {
        return status;
    }
}

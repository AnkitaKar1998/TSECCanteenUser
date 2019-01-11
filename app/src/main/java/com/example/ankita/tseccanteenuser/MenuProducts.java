package com.example.ankita.tseccanteenuser;

public class MenuProducts {
    private String availability,description,image,name,price;

//    public MenuProducts(int image, String p_name, String prod_desc, String price, String quantity) {
//        this.image = image;
//        this.p_name = p_name;
//        this.prod_desc = prod_desc;
//        this.price = price;
//        this.quantity=quantity;
//    }


    public String getAvailability() {
        return availability;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

package com.example.ankita.tseccanteenuser;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersModelClass {

    String amount, studentName, studentId, orderNo, otp;
    ArrayList<MyFoodModelClass> foods;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ArrayList<MyFoodModelClass> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<MyFoodModelClass> foods) {
        this.foods = foods;
    }

    //    String order_id,total_price,del_status;
//    List<MyFoodModelClass> mfmc;
//
//    public MyOrdersModelClass( String order_id, String total_price, String del_status, List<MyFoodModelClass> mfmc) {
//        this.order_id = order_id;
//        this.total_price = total_price;
//        this.del_status = del_status;
//        this.mfmc = mfmc;
//    }
//
//    public List<MyFoodModelClass> getMfmc() {
//        return mfmc;
//    }
//
//    public void setMfmc(List<MyFoodModelClass> mfmc) {
//        this.mfmc = mfmc;
//    }
//
//    public String getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(String order_id) {
//        this.order_id = order_id;
//    }
//
//    public String getTotal_price() {
//        return total_price;
//    }
//
//    public void setTotal_price(String total_price) {
//        this.total_price = total_price;
//    }
//
//    public String getDel_status() {
//        return del_status;
//    }
//
//    public void setDel_status(String del_status) {
//        this.del_status = del_status;
//    }

}

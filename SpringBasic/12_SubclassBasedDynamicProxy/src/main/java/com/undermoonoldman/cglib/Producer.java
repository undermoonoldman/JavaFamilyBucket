package com.undermoonoldman.cglib;


public class Producer{
    public void saleProduct(Float money){
        System.out.println("sale product and get money : " + money);
    }

    public void afterService(Float money){
        System.out.println("offer afterservice and get money : " + money);
    }
}

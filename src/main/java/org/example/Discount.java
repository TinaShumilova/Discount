package org.example;

public class Discount {
    private double zeroDiscount = 0;
    private double minDiscount = 5;
    private double maxDiscount = 7;

    public double getCorrectDiscount(double amount, Client client){
        if (amount<15000){
            return zeroDiscount;
        } else if (amount>=15000 & amount < 20000) {
            if (client.getStatusVIP()==true){
                return minDiscount;
            }else {
                return zeroDiscount;
            }
        }else {
            return maxDiscount;
        }
    }

}

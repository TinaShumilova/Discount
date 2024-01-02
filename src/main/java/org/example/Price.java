package org.example;

public class Price extends Discount {
    private Client client;
    private Vehicle vehicle;

    public Price(Client client, Vehicle vehicle){
        this.client=client;
        this.vehicle=vehicle;
    }

    public double getCorrectPrice() throws ImposibleValue {
        if (vehicle.getVehiclePrice()>0) {
            double discountPrice = vehicle.getVehiclePrice() * getCorrectDiscount(vehicle.getVehiclePrice(), client) / 100;
            return vehicle.getVehiclePrice() - discountPrice;
        }else {
            throw new ImposibleValue();
        }
    }
}

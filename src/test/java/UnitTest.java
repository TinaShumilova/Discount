import org.example.Client;
import org.example.ImposibleValue;
import org.example.Price;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    public void testLessThen15000NotVIP() throws ImposibleValue {
        Client client = new Client();
        Vehicle vehicle = new Vehicle(14999.99);
        Price price = new Price(client, vehicle);
        assertEquals(0, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(14999.99, price.getCorrectPrice());
    }

    @Test
    public void testEquals15000NotVIP() throws ImposibleValue {
        Client client = new Client();
        Vehicle vehicle = new Vehicle(15000);
        Price price = new Price(client, vehicle);
        assertEquals(0, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(15000.00, price.getCorrectPrice());
    }

    @Test
    public void testEquals15000VIP() throws ImposibleValue {
        Client client = new Client();
        client.setStatusVIP(true);
        Vehicle vehicle = new Vehicle(15000.00);
        Price price = new Price(client, vehicle);
        assertEquals(5, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(14250.00, price.getCorrectPrice());
    }

    @Test
    public void testLessThen20000NotVIP() throws ImposibleValue {
        Client client = new Client();
        Vehicle vehicle = new Vehicle(19999.99);
        Price price = new Price(client, vehicle);
        assertEquals(0, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(19999.99, price.getCorrectPrice());
    }

    @Test
    public void testLessThen20000VIP() throws ImposibleValue {
        Client client = new Client(true);
        Vehicle vehicle = new Vehicle(19999.99);
        Price price = new Price(client, vehicle);
        assertEquals(5, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(18999.9905, price.getCorrectPrice());
    }

    @Test
    public void testEquals20000NotVIP() throws ImposibleValue {
        Client client = new Client();
        Vehicle vehicle = new Vehicle(20000);
        Price price = new Price(client, vehicle);
        assertEquals(7, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(18600.00, price.getCorrectPrice());
    }

    @Test
    public void testMoreThen20000VIP() throws ImposibleValue {
        Client client = new Client(true);
        Vehicle vehicle = new Vehicle(21000);
        Price price = new Price(client, vehicle);
        assertEquals(7, price.getCorrectDiscount(vehicle.getVehiclePrice(), client));
        assertEquals(19530, price.getCorrectPrice());
    }

    @Test
    public void testZero()  {
        Client client = new Client();
        Vehicle vehicle = new Vehicle(0);
        Price price = new Price(client, vehicle);
        String actual = "";
        try {
            price.getCorrectPrice();
        } catch (ImposibleValue e) {
            actual = e.getMessage();
        }
        String expected = "Impossible value. Try again";
        assertEquals(expected, actual);
    }

    @Test
    public void testNegativeValue()  {
        Client client = new Client();
        Vehicle vehicle = new Vehicle(-120000.00);
        Price price = new Price(client, vehicle);
        String actual = "";
        try {
            price.getCorrectPrice();
        } catch (ImposibleValue e) {
            actual = e.getMessage();
        }
        String expected = "Impossible value. Try again";
        assertEquals(expected, actual);
    }

}

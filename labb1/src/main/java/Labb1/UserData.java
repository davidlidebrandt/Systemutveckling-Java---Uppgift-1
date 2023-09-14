package Labb1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class UserData {

    private List<HourlyPrice> prices = Arrays.asList(new HourlyPrice[24]);

    public List<HourlyPrice> getPricesPerHour() {
        return prices;
    }

    public void setPricesPerHour(int index, int price) {
        prices.set(index, new HourlyPrice(index, price));
    }

    class HourlyPrice {
        public int hour;
        public int price;

        public HourlyPrice(int hour, int price) {
            this.hour = hour;
            this.price = price;
        }

    }
}

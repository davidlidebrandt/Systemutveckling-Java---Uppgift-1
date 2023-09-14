package Labb1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import Labb1.UserData.HourlyPrice;

public class UserInterface {
    public StringBuilder mainMenu() {
        return new StringBuilder("Elpriser")
        .append("\n")
        .append("========")
        .append("\n")
        .append("1. Inmatning")
        .append("\n")
        .append("2. Min, Max, Medel")
        .append("\n")
        .append("3. Sortera")
        .append("\n")
        .append("4. Bästa Laddningstid (4h)")
        .append("\n")
        .append("e. Avsluta")
        ;
    }

    public String priceInput(int currentInterval) {
        return "Enter a price for interval" + currentInterval;
    }

    public String minMaxAvgPrices(List<HourlyPrice> data) {
        List<HourlyPrice> currentData = new ArrayList<>(data);
        Collections.sort(currentData, (v1,v2)-> {return v1.price - v2.price;});
      
        int minVal = currentData.get(0).price;
        int maxVal = currentData.get(23).price;
        int avgVal = 0;
        
        for(HourlyPrice hp: currentData) {
            avgVal += hp.price;
        }
        avgVal = avgVal/24;
        
        return "Min: " + minVal + ", Max: " + maxVal + ", Average: " + avgVal;
    }
}

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

    public void sortedValues(List<HourlyPrice> data) {
        List<HourlyPrice> currentData = new ArrayList<>(data);
        Collections.sort(currentData, (v1,v2)-> {return v1.price - v2.price;});
        
        for(HourlyPrice v: currentData) {
            String intervalStart = String.valueOf(v.hour);
            String intervalEnd = String.valueOf(v.hour + 1);
            if(intervalStart.length() < 2) {
                intervalStart = "0" + intervalStart;
            }
            if(intervalEnd.length() < 2) {
                intervalEnd = "0" + intervalEnd;
            }
            String currentValues = intervalStart + "-" + intervalEnd + " " + v.price + " öre";
            System.out.println(currentValues);
        }
    }

    public String cheapestHours(List<HourlyPrice> data) {
        int cheapestIntervalStart = 0;
        int cheapestIntervalEnd = 3;
        int index = 0;
        int listLength = data.size() - 1;
        int sum = data.get(0).price 
                + data.get(1).price
                + data.get(2).price
                + data.get(3).price;
        
        for(HourlyPrice hp: data) {
            int firstHour = hp.price;
            int secondHour = index + 1 > listLength ? data.get(index + 1 - listLength - 1).price : data.get(index + 1).price;
            int thirdHour = index + 2 > listLength ? data.get(index + 2 - listLength - 1).price : data.get(index + 1).price;
            int fourthHour = index + 3 > listLength ? data.get(index + 3 - listLength - 1).price : data.get(index +1 ).price;
            int currentPrice = firstHour + secondHour + thirdHour + fourthHour;
            
            if(currentPrice < sum) {
                sum = currentPrice;
                cheapestIntervalStart = index;
                cheapestIntervalEnd = index + 3 > listLength ? index + 3 - listLength - 1 : index + 3;
            }
            
            index++;
            System.out.println(sum + "sum");
            System.out.println(cheapestIntervalStart + "start");
            System.out.println(cheapestIntervalEnd + "end");
        }
        String startingHour = String.valueOf(cheapestIntervalStart).length() < 2 ? "0" + String.valueOf(cheapestIntervalStart): String.valueOf(cheapestIntervalStart);
        int avgHourCost = sum/4;
        return "För att få billigast pris ska du börja ladda klockan " + startingHour + ", medelpriset per timme blir " + avgHourCost;
    }
}

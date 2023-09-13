package Labb1;

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
}

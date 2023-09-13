package Labb1;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    
    public static void main(String[] args) {
        Boolean running = true;
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface();
        
        while(running) {
            System.out.println(userInterface.mainMenu());
            String userInput = scanner.nextLine();
          
            if(userInput.equals("e") || userInput.equals("E")) {
                scanner.close();
                running = false;
            }
            else if(userInput.equals("1")) {
                int counter = 1;
                while(counter <= 24) {
                    System.out.println("Enter a price for interval " + counter);
                    userInput = scanner.nextLine();
                    try {
                        int price = Integer.parseInt(userInput);
                        counter++;
                    } catch (Exception e) {
                        System.out.println("Invalid number");
                    }
                    
                }
            }
            else if(userInput.equals("2")) {
                
            }
            else if(userInput.equals("3")) {
                
            }
            else if(userInput.equals("4")) {
                
            }
        }
    }
}
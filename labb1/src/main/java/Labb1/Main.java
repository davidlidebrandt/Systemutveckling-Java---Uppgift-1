package Labb1;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Boolean running = true;
        Scanner scanner = new Scanner(System.in);
        
        while(running) {
            System.out.println(UserInterface.mainMenu);
            String userInput = scanner.nextLine();
          
            if(userInput.equals("e") || userInput.equals("E")) {
                scanner.close();
                running = false;
            }
            else if(userInput.equals("1")) {

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
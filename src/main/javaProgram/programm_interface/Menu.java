package programm_interface;

import animals.Animal;

import java.util.ArrayList;
import java.util.Scanner;

import static programm_interface.MenuInterface.menuInterface;

public class Menu {
    public static void menu(ArrayList<Animal> animals) {
        int command;
        boolean exceptionCheck =  true;
        Scanner sc = new Scanner(System.in);

        while (exceptionCheck) {
            System.out.println("Здравствуйте! Добро пожаловать в реестр домашних животных.");
            System.out.println("""
                                    
                                    
                    1. Продолжить работу в приложении
                    2. Выйти из приложения
                                    
                    """);

            command = Integer.parseInt(sc.nextLine());

            try {
                if (command == 2) {
                    exceptionCheck = false;
                    System.out.println("Завершение работы.");
                } else if (command == 1) {
                    exceptionCheck = false;
                    menuInterface(animals);
                }
            } catch (InputFunctionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
